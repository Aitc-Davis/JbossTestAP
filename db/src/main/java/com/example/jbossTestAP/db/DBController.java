package com.example.jbossTestAP.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class DBController {
	private static final Logger LOG = LoggerFactory.getLogger(DBController.class);

	@Autowired
	MessageRecordRepository repository;

	@PostMapping(value = "/save",
			consumes = TEXT_PLAIN_VALUE
	)
	public ResponseEntity<MessageRecord> save(@RequestBody String msg) {
		MessageRecord save = repository.save(new MessageRecord(msg));
		LOG.info("Save:[{}]", save == null ? "null" : save.toString());
		return ResponseEntity.of(Optional.of(save));
	}

	@PostMapping(value = "/find/{id}",
			consumes = TEXT_PLAIN_VALUE
	)
	public ResponseEntity<MessageRecord> find(@PathVariable String id) {
		Optional<MessageRecord> record = repository.findById(id);
		return ResponseEntity.of(record);
	}
}