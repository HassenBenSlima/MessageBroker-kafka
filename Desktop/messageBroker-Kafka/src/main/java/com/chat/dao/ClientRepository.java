package com.chat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByNameAndPassword(String name, String password);
}
