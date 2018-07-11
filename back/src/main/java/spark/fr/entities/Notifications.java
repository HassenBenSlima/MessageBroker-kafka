package spark.fr.entities;

import java.util.ArrayList;
import java.util.List;

public class Notifications {

	private int count;

	private List<Message> messages = new ArrayList<>();

	public Notifications(int count) {
		this.count = count;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment() {
		this.count++;
	}
}
