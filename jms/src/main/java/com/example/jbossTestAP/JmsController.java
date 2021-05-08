package com.example.jbossTestAP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class JmsController {
	private static final Logger LOG = LoggerFactory.getLogger(JmsController.class);

	@Autowired
	JmsService jms;

	@PostMapping(value = "/send/queue/{queue}",
			consumes = TEXT_PLAIN_VALUE,
			produces = TEXT_PLAIN_VALUE
	)
	public void send(@PathVariable String queue, @RequestBody String msg) {
		LOG.info("Send to Queue [{}]:[{}]", queue, msg);
		jms.sendToQueue(queue, msg);
	}
}