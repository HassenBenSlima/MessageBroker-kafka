package com.chat.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.chat.entities.Message;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@Value("${jsa.kafka.topic}")
	private String kafkaTopic;

	public void send(Message message) {
		LOGGER.info("sending data='{}' to topic='{}'", message, kafkaTopic);
		kafkaTemplate.send(kafkaTopic, message);
	}
}
