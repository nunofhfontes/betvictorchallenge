package com.traderfactory.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.traderfactory.urls.UrlConstant;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class TraderFactoryController {
	
	@Autowired
    private Example example;

	@RequestMapping("/")
	public String home() {
		String message = "  dsdsd ";
		
        return message;
    }
	
	@RequestMapping(value="/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloMethod() {
		
		System.out.println("SAY HELLO!!!");
		
		System.out.println("example of autowired: "+ example.example);
		
		String message = "Hello";
		
        return message;
    }
	
	@RequestMapping("/zen")
	@ResponseBody
	public String zenMethod() {
		String message = "zen";
		
		sendHTTPRequest();
		
        return message;
    }
	
	public void sendHTTPRequest() {
		
    	//send an HTTP request to hit helloMethod
    	
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = UrlConstant.BACKEND_ENDPOINT;
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);

		System.out.println("HTTP response Status: "+response.getStatusCode());
		System.out.println("HTTP response Body: "+response.getBody());
		System.out.println("HTTP response Headers: "+response.getHeaders());
		
    }
    
    @RequestMapping("/shoot")
	@ResponseBody
	public String shootHTTPRequest() {
		
    	String message = "Http request to 'http://localhost:8080/hello' shot, check console for status";
    	
		sendHTTPRequest();
		
		return message;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TraderFactoryController.class, args);
	}
}



















