package spark.fr.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import spark.fr.entities.Message;

@Service
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@Value("${jsa.kafka.topic}")
	private String kafkaTopic;

	public void send(Message message) {
		log.info("sending data='{}'", message);
		kafkaTemplate.send(kafkaTopic, message);
	}
}
