package com.example.jbossTestAP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class JmsController {
	private static final Logger LOG = LoggerFactory.getLogger(JmsController.class);

	@Autowired
	JmsService jms;

	@PostMapping(value = "/send/{topic}",
			consumes = TEXT_PLAIN_VALUE
	)
	public void sendToTopic(@PathVariable String topic, @RequestBody String msg) {
		LOG.info("Send to Topic [{}]:[{}]", topic, msg);
		jms.sendToTopic(topic, msg);
	}
}