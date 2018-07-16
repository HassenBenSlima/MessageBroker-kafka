package com.chat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chat.entities.Client;
import com.chat.entities.MessagesClients;

@Repository
public interface MessagesClientsRepository extends JpaRepository<MessagesClients, Long> {

	@Query("select mc.sender from MessagesClients mc")
	List<Client> getClientReciever();

	@Query("select mc.reciever from MessagesClients mc")
	List<Client> getClientSender();

}
