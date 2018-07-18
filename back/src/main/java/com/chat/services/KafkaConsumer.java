package com.chat.services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.chat.dao.ClientRepository;
import com.chat.dao.MessageRepository;
import com.chat.dao.MessagesClientsRepository;
import com.chat.entities.Client;
import com.chat.entities.Message;
import com.chat.entities.MessagesClients;
import com.chat.entities.Notifications;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	MessagesClientsRepository messagesClientsRepository;

	@Autowired
	private SimpMessagingTemplate template;

	private Notifications notifications = new Notifications(0);

	@KafkaListener(topics = "${jsa.kafka.topic}")
	public void receive(ConsumerRecord<?, ?> consumerRecord) {
		LOGGER.info("received data='{}'", consumerRecord);
		Message message1 = (Message) consumerRecord.value();
		LOGGER.info("message='{}'", message1);

		notifications.increment();

		this.template.convertAndSend("/topic/chatting", message1);
		this.template.convertAndSend("/topic/notification", notifications);
		Message savedMessage = messageRepository.save(new Message(message1.getContent(), message1.getUser()));

		Client sender = clientRepository.findByName(savedMessage.getUser());
		List<Client> clients = clientRepository.findAll();
		clients.forEach(c -> {
			if (!c.equals(sender))
				messagesClientsRepository.save(new MessagesClients(sender, c, savedMessage, new Date()));
		});

		latch.countDown();
	}

}
