package com.example.jbossTestAP.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "MessageRecord")
public class MessageRecord {

	@Id
	private String id;

	@Column()
	private String message;

	public MessageRecord() {
	}

	public MessageRecord(String message) {
		this.message = message;
		setId(UUID.randomUUID().toString());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageRecord{" +
				"id='" + id + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
