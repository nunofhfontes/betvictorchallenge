package com.traderfactory.components;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuxController {
	
	@RequestMapping(value="/aux", produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloMethod() {

		System.out.println("------------>>> AUX Controller <<<------------");

		String message = "Aux Controller, second REST API";

		return message;
	}
	

}
