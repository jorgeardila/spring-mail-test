package com.test.spring.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.dto.Response;
import com.test.spring.email.smtp.SmtpMailSender;

@RestController
public class SendMailController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping(value = "/send-mail", method = RequestMethod.GET)
	public Response sendMail(@RequestParam("to") String to, 
							@RequestParam("subject") String subject, 
							@RequestParam("message") String message) throws MessagingException {

		smtpMailSender.send(to, subject, message);
		
		Response response = new Response();
		response.setResult("Email Sent.");
		
		System.out.println("Email Sent.");
		
		return response;
	}

}
