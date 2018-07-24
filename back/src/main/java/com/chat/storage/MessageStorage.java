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

	private List<Message> storageMessages = new ArrayList<>();

	public MessageStorage() {
		super();
	}

	public List<Message> getStorageMessages() {
		return storageMessages;
	}

	public void setStorageMessages(List<Message> storageMessages) {
		this.storageMessages = storageMessages;
	}

	public void addMessage(Message message) {
		storageMessages.add(message);
	}

	public void messagesConsumer() {

		storageMessages.forEach(msg -> LOGGER.info("message : {}", msg.getIdMsg()));
	}

	public void clear() {
		storageMessages.clear();
	}
}
