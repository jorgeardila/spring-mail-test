package com.test.spring.email.pop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class Pop3MailReceiver {

	@Autowired
	DirectChannel receiveChannel;
	
	@PostConstruct
    public void init() {
		receiveChannel.subscribe(new MessageHandler() {
			public void handleMessage(Message<?> message) throws MessagingException {
				processMessage(message);
			}
		});
    }
	
	private void processMessage(Message<?> message) {
		System.out.println("\nProcess Message: " + message + "\n");
	}

}
