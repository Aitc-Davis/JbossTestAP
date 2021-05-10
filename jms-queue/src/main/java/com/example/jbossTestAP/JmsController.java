package com.example.jbossTestAP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class JmsController {
	private static final Logger LOG = LoggerFactory.getLogger(JmsController.class);

	@Autowired
	JmsService jms;

	@PostMapping(value = "/send/{queue}",
			consumes = TEXT_PLAIN_VALUE
	)
	public void sendToQueue(@PathVariable String queue, @RequestBody String msg) {
		LOG.info("Send to queue [{}]:[{}]", queue, msg);
		jms.sendToQueue(queue, msg);
	}

	@PostMapping(value = "/receive/{queue}",
			produces = APPLICATION_JSON_VALUE
	)
	public ResponseEntity<String> receiveFromQueue(@PathVariable String queue) {
		Optional<String> msg = jms.receiveFromQueue(queue);
		LOG.info("Receive from queue [{}]:[{}]", queue, msg);
		return ResponseEntity.of(msg);
	}
}