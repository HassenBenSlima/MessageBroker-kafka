package com.chat.storage;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chat.entities.Message;

@Component
public class MessageStorage {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageStorage.class);

	private List<Message> storage = new ArrayList<>();
	
	public void put(Message message) {
		storage.add(message);
	}

	public void messagesConsumer() {

		storage.forEach(msg -> 
			LOGGER.info("message : {}", msg.getIdMsg())
		);
	}

	public void clear() {
		storage.clear();
	}
}
