package spark.fr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;

	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "reciever", fetch = FetchType.LAZY)
	private Collection<MessagesClients> messagesReciever = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
	private Collection<MessagesClients> messagesSender = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<MessagesClients> getMessagesReciever() {
		return messagesReciever;
	}

	public void setMessagesReciever(Collection<MessagesClients> messagesReciever) {
		this.messagesReciever = messagesReciever;
	}

	public Collection<MessagesClients> getMessagesSender() {
		return messagesSender;
	}

	public void setMessagesSender(Collection<MessagesClients> messagesSender) {
		this.messagesSender = messagesSender;
	}

	// @JsonIgnore
	// @ManyToMany
	// @JoinTable(name = "messages_clients", joinColumns = { @JoinColumn(name =
	// "idClient") }, inverseJoinColumns = {
	// @JoinColumn(name = "idMsg") })
	// private Collection<Message> messages = new ArrayList<>();

}
