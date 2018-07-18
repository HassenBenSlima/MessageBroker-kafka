package com.chat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMsg;

	private String content;
	@Transient
	private String user;

	private boolean viewMessage = false;

	public Message() {
		super();
	}

	public Message(String content, String user) {
		super();
		this.content = content;
		this.user = user;
	}

	public Long getIdMsg() {
		return idMsg;
	}

	public void setIdMsg(Long idMsg) {
		this.idMsg = idMsg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isViewMessage() {
		return viewMessage;
	}

	public void setViewMessage(boolean viewMessage) {
		this.viewMessage = viewMessage;
	}

	@Override
	public String toString() {
		return "Message [idMsg=" + idMsg + ", content=" + content + ", viewMessage=" + viewMessage + "]";
	}

}
