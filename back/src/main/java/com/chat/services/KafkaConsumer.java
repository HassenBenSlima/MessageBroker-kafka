package com.chat.services;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.chat.dao.ClientRepository;
import com.chat.dao.MessageRepository;
import com.chat.dao.MessagesClientsRepository;
import com.chat.entities.Message;
import com.chat.entities.Notifications;
import com.chat.storage.MessageStorage;

@Service
public class KafkaConsumer implements ConsumerSeekAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	private ConsumerSeekCallback consumerSeekCallback;

	@Autowired
	private MessageStorage messageStorage;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	MessagesClientsRepository messagesClientsRepository;

	@Autowired
	private SimpMessagingTemplate template;

	private Notifications notifications = new Notifications(0);

	// ConsumerRecord<?, ?>
	@KafkaListener(topics = "${jsa.kafka.topic}")
	public void receive(Message consumerRecord) {
		LOGGER.info("received data='{}'", consumerRecord);
		messageStorage.addMessage(consumerRecord);

		// List<Message> listMessages = messageStorage.getStorageMessages();

		// for (Message item : listMessages) {
		//
		// LOGGER.info(item.getContent());
		// }
		//
		// LOGGER.info("---------------------------------------------");
		// Collections.reverse(listMessages);
		//
		// for (Message item : listMessages) {
		//
		// LOGGER.info(item.getContent());
		// }

		if ("everyone".equals(consumerRecord.getSendTo())) {
			this.template.convertAndSend("/topic/chatting", consumerRecord);

			notifications.increment();
			this.template.convertAndSend("/topic/notification", notifications);

		} else {
			this.template.convertAndSend("/topic/chatting-" + consumerRecord.getSendTo(), consumerRecord);
			this.template.convertAndSend("/topic/chatting-" + consumerRecord.getUser(), consumerRecord);
		}

		latch.countDown();
	}

	public ConsumerSeekCallback getConsumerSeekCallback() {
		return consumerSeekCallback;
	}

	@Override
	public void registerSeekCallback(ConsumerSeekCallback callback) {
		this.consumerSeekCallback = callback;
	}

	@Override
	public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
		assignments.forEach((t, o) -> callback.seek(t.topic(), t.partition(), 0));
	}

	@Override
	public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {

	}

}
