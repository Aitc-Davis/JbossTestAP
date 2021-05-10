package com.example.jbossTestAP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {
	private static final Logger LOG = LoggerFactory.getLogger(JmsService.class);

	private final JmsTemplate jmsTemplate;

	@Autowired
	public JmsService(JmsTemplate jmsTemplate) {
		jmsTemplate.setReceiveTimeout(1000);
		this.jmsTemplate = jmsTemplate;
	}

	public void sendToTopic(String topic, String message) {
		jmsTemplate.convertAndSend(topic, message);
	}

	@JmsListener(destination = "testTopic")
	public void receiveFromTopic(String msg) {
		LOG.info("Get Message from topic [testTopic]:[{}]", msg);
	}
}