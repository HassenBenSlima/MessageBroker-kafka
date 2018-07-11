package spark.fr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spark.fr.dao.MessageRepository;
import spark.fr.entities.Message;
import spark.fr.services.KafkaProducer;
import spark.fr.storage.MessageStorage;

@RestController
@RequestMapping(value = "/kafka")
public class MessageController {

	@Autowired
	KafkaProducer producer;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	MessageStorage storage;

	@GetMapping(value = "/messages")
	public List<Message> getContacts() {
		return messageRepository.findAll();
	}

	@PostMapping(value = "/producer")
	public Message producer(@RequestBody Message message) {
		System.out.println("hassen++++++++++++++++++++++++");

		producer.send(message);
		System.out.println("hassen------------------------");
		return message;
	}

	@GetMapping(value = "/consumer")
	public String getAllRecievedMessage() {
		storage.messagesConsumer();
		storage.clear();

		return "Done";
	}

	@GetMapping(value = "/messages/{idClient}")
	public Message getMessage(@PathVariable Long idMsg) {
		return messageRepository.findById(idMsg).get();
	}

}
