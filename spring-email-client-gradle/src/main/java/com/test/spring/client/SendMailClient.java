package com.test.spring.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.spring.dto.Response;

@SpringBootApplication
public class SendMailClient implements CommandLineRunner {	

	/*
	 	RestTemplateMethods: 
	 	
		DELETE	delete(String, String...)
		GET		getForObject(String, Class, String...)
		HEAD	headForHeaders(String, String...)
		OPTIONS	optionsForAllow(String, String...)
		POST	postForLocation(String, Object, String...)
		PUT		put(String, Object, String...)
	 */
	
    public static void main(String args[]) {
        SpringApplication.run(SendMailClient.class);
    }
	
    public void run(String... strings) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/send-mail");
		builder = builder.queryParam("to", "jorge.ardila@prodigious.com");
		builder = builder.queryParam("subject", "Test Email");
		builder = builder.queryParam("message", "This is a spring email test from RestTemplate.");
		
		Response response = restTemplate.getForObject(builder.build().encode().toUri(), Response.class);
	    
		System.out.println("Response: " + response.getResult());
    }
}
