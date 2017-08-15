package com.challenge.services;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.challenge.domain.Gibberish;
import com.challenge.domain.Summary;
import com.challenge.repository.SummaryRepository;
import com.challenge.urls.UrlConstant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableAsync
@Component
public class HttpClientCallImpl implements HttpClientCall{

	@Autowired
	private SummaryRepository summaryRepository;
	
	@Override
	@Async
	public Future<String> getAndProcessRandomText(int p_start, int p_end, int w_count_min, int w_count_max, Summary summaryObj, Boolean isLast) 
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(getRandomTextApiURL(p_start, w_count_min, w_count_max), HttpMethod.GET, getHttpEntity(), String.class);
        
		ObjectMapper mapper = new ObjectMapper();
		Gibberish gibObj = mapper.readValue(response.getBody(), Gibberish.class);
		
		//Get the start time
		
		String httpTime = gibObj.getTime();
		String[] splitHttpTime = httpTime.split(":");
		LocalTime startTime = LocalTime.of(Integer.valueOf(splitHttpTime[0]), Integer.valueOf(splitHttpTime[1]), Integer.valueOf(splitHttpTime[2]), 0);
        
		//Separate paragraphs and removed unnecessary characters
		String[] unformattedParagraphsArray = gibObj.getTextOut().split("\r");
		List<String> paragraphsList = new ArrayList<>();
		
		for(String paragraph : unformattedParagraphsArray){
			paragraph = paragraph.replace(UrlConstant.HTML_PARAGRAPH_START, UrlConstant.EMPTY_STRING);
			paragraph = paragraph.replace(UrlConstant.HTML_PARAGRAPH_END, UrlConstant.EMPTY_STRING);
			paragraph = paragraph.replace(UrlConstant.POINT, UrlConstant.EMPTY_STRING);
			paragraphsList.add(paragraph);
		}
		
		for(String tmpParagraph : paragraphsList){
			String[] wordsOfParagraph = tmpParagraph.split(UrlConstant.SPACES);
			
			for(String tmpWord : wordsOfParagraph){
				
				tmpWord = tmpWord.toLowerCase();
				
				if(summaryObj.getWordsMap().containsKey(tmpWord)){
					Integer oldValue = summaryObj.getWordsMap().get(tmpWord);
					summaryObj.getWordsMap().replace(tmpWord, oldValue, oldValue + 1);
				}else{
					summaryObj.getWordsMap().putIfAbsent(tmpWord, 1);
				}
			}
		}
		
		//Get the End processing time 
		LocalTime endTime = LocalTime.now();
		Duration duration = Duration.between(startTime, endTime);
		Double durationInSeconds = Double.valueOf(duration.getNano()) /1000000000;
		
		if(summaryObj.getTotalDurationInSeconds().containsKey(UrlConstant.TOTAL_DURATION_IN_SECONDS)){
			Double tmpTime = summaryObj.getTotalDurationInSeconds().get(UrlConstant.TOTAL_DURATION_IN_SECONDS);
			summaryObj.getTotalDurationInSeconds().replace(UrlConstant.TOTAL_DURATION_IN_SECONDS, tmpTime, tmpTime+durationInSeconds);
		}else{
			summaryObj.getTotalDurationInSeconds().putIfAbsent(UrlConstant.TOTAL_DURATION_IN_SECONDS, durationInSeconds);
		}
			
		//Calculate the average time, get the most frequent word, and persist object
		if(isLast){
			
			//Set totalProcessingTime
			summaryObj.setTotalProcessingTime(summaryObj.getTotalDurationInSeconds().get(UrlConstant.TOTAL_DURATION_IN_SECONDS));
			
			//Set average paragraph processing time
			Double avgParagraphProcTime = (summaryObj.getTotalDurationInSeconds().get(UrlConstant.TOTAL_DURATION_IN_SECONDS) / summaryObj.getTotalNrOfParagraphs());
			summaryObj.setAvgParagProcTime(avgParagraphProcTime);
			
			//Set average paragraph size -> avgParagrize
			//Set most frequent word -> freqWord
			Integer frequency = null;
			String mostFrequent = null;
			Integer wordCount = 0;
			for(String s : summaryObj.getWordsMap().keySet()){
			    Integer i = summaryObj.getWordsMap().get(s);
			    wordCount = wordCount + i; 
			    if(frequency == null)
			         frequency = i;
			    if(i > frequency){
			         frequency = i;
			         mostFrequent = s;
			    }
			}
			summaryObj.setFreqWord(mostFrequent);
			summaryObj.setAvgParagrize(wordCount / (double) summaryObj.getTotalNrOfParagraphs());
			
			//set an insertion date
			summaryObj.setInsertionDate(Timestamp.from(Instant.now()));
			
			//Persist object on database
			summaryRepository.save(summaryObj);
			
		}
		
		return new AsyncResult<String>(mapper.writeValueAsString(summaryObj));
	}

	private HttpEntity<String> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add(UrlConstant.USER_AGENT_NAME, UrlConstant.USER_AGENT_VALUE);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		return entity;
	}
	
	private String getRandomTextApiURL(int p_start, int w_count_min, int w_count_max){
		
		return UrlConstant.RANDOM_TEXT_API_BASE_URL + p_start + "/" + w_count_min + "-" + w_count_max;
	}

}
