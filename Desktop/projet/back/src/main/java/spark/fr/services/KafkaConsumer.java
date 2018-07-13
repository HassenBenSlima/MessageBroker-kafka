package spark.fr.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import spark.fr.dao.MessageRepository;
import spark.fr.entities.Message;
import spark.fr.storage.MessageStorage;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	MessageStorage storage;
	@Autowired
	MessageRepository messageClient;

	@KafkaListener(topics = "${jsa.kafka.topic}")
	public void processMessage(Message message) {
		// public void processMessage(@Payload Message message,
		// @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
		// @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
		// @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
		// @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
		System.out.println("__________________-__________________");
		System.out.println("received content:" + message);

		Message msg = messageClient.save(message);
		log.info("received content = '{}'", msg.getIdMsg());

		storage.put(message);

	}
}
