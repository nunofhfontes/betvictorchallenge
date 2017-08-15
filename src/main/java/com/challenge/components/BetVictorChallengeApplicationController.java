package com.challenge.components;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.domain.Summary;
import com.challenge.repository.SummaryRepository;
import com.challenge.urls.UrlConstant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class BetVictorChallengeApplicationController {
	
	@Autowired
	private RandomTextManagement randomTextManagement;
	
	@GetMapping(value=UrlConstant.BACKEND_RANDOM_TEXT_ENDPOINT_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRandomTextFromAPI(@RequestParam("p_start") int p_start, @RequestParam("p_end") int p_end,
    		@RequestParam("w_count_min") int w_count_min, @RequestParam("w_count_max") int w_count_max) throws JsonParseException, JsonMappingException, IOException, ParseException, InterruptedException, ExecutionException {
		
		String jsonResponse = randomTextManagement.processRequestForRandomTextAPI(p_start, p_end, w_count_min, w_count_max);
		
        return jsonResponse;
    }
	
	@GetMapping(value=UrlConstant.BACKEND_RANDOM_TEXT_HISTORY_ENDPOINT_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRandomTextHistory() throws JsonProcessingException {
		
        return randomTextManagement.getRandomTextHistory();
    }
    
}
