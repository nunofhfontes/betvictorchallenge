package com.challenge.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.Future;

import com.challenge.domain.Summary;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface HttpClientCall {
	
	public Future<String> getAndProcessRandomText(int p_start, int p_end, int w_count_min, int w_count_max, Summary summaryObj, Boolean isLast) throws JsonParseException, JsonMappingException, IOException, ParseException;

}
