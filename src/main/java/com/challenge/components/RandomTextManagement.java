package com.challenge.components;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface RandomTextManagement {

	public String processRequestForRandomTextAPI(int p_start, int p_end, int w_count_min, int w_count_max) throws JsonParseException, 
	JsonMappingException, IOException, ParseException, InterruptedException, ExecutionException;
	
	public String getRandomTextHistory() throws JsonProcessingException;
	
}
