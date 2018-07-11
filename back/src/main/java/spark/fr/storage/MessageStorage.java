package spark.fr.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spark.fr.dao.MessageRepository;
import spark.fr.entities.Message;

@Component
public class MessageStorage {

	private List<Message> storage = new ArrayList<Message>();
	@Autowired
	MessageRepository messageRepository;

	public void put(Message message) {
		storage.add(message);
	}

	public void messagesConsumer() {

		storage.forEach(msg -> {
			Message m=messageRepository.save(msg);
			System.out.println(m.getIdMsg());

		}

		);

	}

	public void clear() {
		storage.clear();
	}
}
