package com.chat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.entities.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
