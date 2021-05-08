package com.example.jbossTestAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public JmsService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendToQueue(String queue, String message) {
		jmsTemplate.convertAndSend(queue, message);
	}

}