package com.challenge.components;

import java.io.IOException;
import java.text.ParseException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.domain.Summary;
import com.challenge.repository.SummaryRepository;
import com.challenge.services.HttpClientCall;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class RandomTextManagementImpl implements RandomTextManagement {
	
	@Autowired
	private HttpClientCall randomTextCall;
	
	@Autowired
	private SummaryRepository summaryRepository;
	
	@Override
	public String processRequestForRandomTextAPI(int p_start, int p_end, int w_count_min, int w_count_max) throws JsonParseException, JsonMappingException, IOException, ParseException, InterruptedException, ExecutionException {
		
		Boolean isLast = false;
		Future<String> jsonResponse = null;
		Summary summaryObj = new Summary();
		
		if(p_start <= p_end){
			
			summaryObj.setTotalNrOfParagraphs(p_end - p_start + 1);
			
			//do the for loop to make the request for Random Text API
			for(;p_start <= p_end; p_start++) {
				
				if(p_start == p_end){
					isLast = true;
				}
				
				jsonResponse = randomTextCall.getAndProcessRandomText(p_start, p_end, w_count_min, w_count_max, summaryObj, isLast);
				
			}
			
		}else if(p_start >= p_end){
			
			summaryObj.setTotalNrOfParagraphs(p_start - p_end + 1);

			//do the for loop to make the request for Random Text API
			for(;p_start >= p_end; p_start--) {

				if(p_start == p_end){
					isLast = true;
				}
				
				jsonResponse = randomTextCall.getAndProcessRandomText(p_start, p_end, w_count_min, w_count_max, summaryObj, isLast);

			}

		}
		//what for a JSON response from asynchronous methods
		while (true) {
	        if (jsonResponse.isDone()) {
	        	return jsonResponse.get();
	        }
		}
	}

	@Override
	public String getRandomTextHistory() throws JsonProcessingException {
		
		List<Summary> summaryList = summaryRepository.findFirst10ByOrderByInsertionDateDesc();
		 ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(summaryList);
	}

}
