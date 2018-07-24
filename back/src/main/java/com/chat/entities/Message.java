package com.chat.entities;

import java.io.Serializable;
import java.util.Date;

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
	
	@Transient
	private String sendTo;

	private Date date;

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

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [idMsg=" + idMsg + ", content=" + content + ", user=" + user + ", sendTo=" + sendTo + ", date="
				+ date + ", viewMessage=" + viewMessage + "]";
	}

}
