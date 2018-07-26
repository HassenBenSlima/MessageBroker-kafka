package com.chat.storage;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chat.entities.Client;

@Component
public class ClientStorage {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientStorage.class);

	private List<Client> participants = new ArrayList<>();

	public ClientStorage() {
		super();
		LOGGER.info("ClientStorage a été chargé");
	}

	public List<Client> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Client> participants) {
		this.participants = participants;
	}

	public void addParticipant(Client c) {
		participants.add(c);
	}

}
