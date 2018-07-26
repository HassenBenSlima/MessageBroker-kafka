package com.chat.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.MessageRepository;
import com.chat.entities.Message;
import com.chat.profanity_checker.ProfanityChecker;
import com.chat.profanity_checker.SessionProfanity;
import com.chat.profanity_checker.TooMuchProfanityException;
import com.chat.services.KafkaProducer;
import com.chat.storage.MessageStorage;

@RestController
@CrossOrigin("*")
public class MessageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private ProfanityChecker profanityFilter;

	@Autowired
	private SessionProfanity profanity;

	@Autowired
	private KafkaProducer producer;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private MessageStorage messageStorage;

	@Value("${jsa.kafka.topic}")
	private String kafkaTopic;

	@MessageMapping("/message")
	public void sendMessage(@Payload Message message) {
		try {
			Thread.sleep(1000);// simulated delay
		} catch (InterruptedException e) {
			LOGGER.info("Interrupted! {}", e);
			// Restore interrupted state...
			Thread.currentThread().interrupt();
		}
		producer.send(message);
		LOGGER.info("message{}", message);
		// Message msg = new Message("test", "test", "test", new Date());
		// for (int i = 0; i < 1000; i++) {
		//
		// }

	}

	@MessageMapping("/chat.private.{username}")
	public Message filterPrivateMessage(@Payload Message message, @DestinationVariable("username") String username) {
		checkProfanityAndSanitize(message);
		producer.send(message);

		return message;
	}

	/**
	 * pour les mots interdit
	 * 
	 * @param message
	 **/
	private void checkProfanityAndSanitize(Message message) {
		long profanityLevel = profanityFilter.getMessageProfanity(message.getContent());
		profanity.increment(profanityLevel);
		message.setContent(profanityFilter.filter(message.getContent()));
	}

	@MessageExceptionHandler
	@SendToUser(value = "/exchange/amq.direct/chat.message", broadcast = false)
	public Message handleProfanity(TooMuchProfanityException e) {
		Message msg = new Message();
		msg.setContent(e.getMessage());
		msg.setDate(new Date());
		msg.setUser("System");
		return msg;
	}

	@GetMapping(value = "/messages")
	public List<Message> getContacts() {
		return messageRepository.findAll();
	}

	@PostMapping(value = "/producer")
	public Message producer(@RequestBody Message message) {
		producer.send(message);
		return message;
	}

	@GetMapping(value = "/messages/{idClient}")
	public Message getMessage(@PathVariable Long idMsg) {
		Message msgValue = null;
		Optional<Message> msg = messageRepository.findById(idMsg);
		if (msg.isPresent()) {
			msgValue = msg.get();
			return msgValue;
		}
		return msgValue;

	}

	@PutMapping(value = "/messages/{id}")
	public Message changeStatusMessage(@PathVariable Long id, @RequestBody Message msg) {
		msg.setIdMsg(id);
		msg.setViewMessage(true);
		return messageRepository.save(msg);
	}

	@GetMapping("/oldMessages")
	public List<Message> getAllOldMessages() {
		return messageStorage.getStorageMessages();
	}

	@GetMapping("/privateMessages")
	public List<Message> getAllPrivateMessageBettweenTwoPersonnes(String sender, String reciever) {
		return messageStorage.getAllMessagesBettweenTwoPersonnes(sender, reciever);
	}

	@GetMapping("/publicMessages")
	public List<Message> getAllPublicMessage() {
		return messageStorage.getPublicMessages();
	}

}
