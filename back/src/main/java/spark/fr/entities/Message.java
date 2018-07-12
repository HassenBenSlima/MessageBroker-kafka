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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMsg;

	private String content;

	@Transient
	private Long idS;

	@JsonManagedReference
	@OneToMany(mappedBy = "message", fetch = FetchType.LAZY)
	private Collection<MessagesClients> clients = new ArrayList<>();

	public Message() {
		super();
	}

	public Message(String content) {
		super();
		this.content = content;
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

	public Long getIdS() {
		return idS;
	}

	public void setIdS(Long idS) {
		this.idS = idS;
	}

}
