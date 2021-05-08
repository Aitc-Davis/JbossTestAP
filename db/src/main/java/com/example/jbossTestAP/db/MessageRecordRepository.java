package com.example.jbossTestAP.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public interface MessageRecordRepository extends JpaRepository<MessageRecord, String> {
}

