package com.example.jbossTestAP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JmsService {
	private static final Logger LOG = LoggerFactory.getLogger(JmsService.class);

	private final JmsTemplate jmsTemplate;

	@Autowired
	public JmsService(JmsTemplate jmsTemplate) {
		jmsTemplate.setReceiveTimeout(1000);
		this.jmsTemplate = jmsTemplate;
	}

	public void sendToQueue(String queue, String message) {
		jmsTemplate.convertAndSend(queue, message);
	}

	public Optional<String> receiveFromQueue(String queue) {
		Object obj = jmsTemplate.receiveAndConvert(queue);
		String str = obj == null ? null : obj.toString();
		return Optional.ofNullable(str);
	}

}