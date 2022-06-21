package com.apiTokenClient.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TokenController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/") 
	public Object getResponse() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      HttpEntity <String> requestEntity = new HttpEntity<String>(headers);
	      
	      String url = "https://stage.communication-scaffold.oodleslab.com/chat-api/chat/auth/authorize?username=pankaj.raj@oodles.io&password=Dpp@12&deviceId=1";
	      ResponseEntity<Object> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Object.class);
		  System.out.println(exchange); 
		  System.out.println("exchanged data is"+exchange.getBody().toString());
		  
		  return exchange.getBody().toString();
		  
	   }
	  

}
