package com.chat.services;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.chat.dao.MessageRepository;
import com.chat.entities.Message;
import com.chat.entities.Notifications;
import com.chat.storage.MessageStorage;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	private Notifications notifications = new Notifications(0);

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	MessageStorage storage;
	@Autowired
	MessageRepository messageClient;

	@KafkaListener(topics = "${jsa.kafka.topic}")
	public void receive(ConsumerRecord<?, ?> consumerRecord) {
		LOGGER.info("received data='{}'", consumerRecord);
		Message message1 = (Message) consumerRecord.value();
		LOGGER.info("message='{}'", message1);

		notifications.increment();

		this.template.convertAndSend("/topic/chatting", message1);
		this.template.convertAndSend("/topic/notification", notifications);
		latch.countDown();
	}

}
