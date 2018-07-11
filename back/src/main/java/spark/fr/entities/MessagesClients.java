package spark.fr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MessagesClients implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idClientS")
	private Client sender;

	/**
	 * un ou plusieurs clients peuvent recevoir un seul message
	 */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idClientR")
	private Client reciever;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idMsg")
	private Message message;

	@Temporal(TemporalType.DATE)
	private Date date;

	public MessagesClients(Client sender, Client reciever, Message message, Date date) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.message = message;
		this.date = date;
	}

	public MessagesClients() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getReciever() {
		return reciever;
	}

	public void setReciever(Client reciever) {
		this.reciever = reciever;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
