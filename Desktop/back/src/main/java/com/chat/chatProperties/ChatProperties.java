package com.chat.chatProperties;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chat")
class ChatProperties {

	private int maxProfanityLevel;
	private Set<String> disallowedWords;

	public int getMaxProfanityLevel() {
		return maxProfanityLevel;
	}

	public void setMaxProfanityLevel(int maxProfanityLevel) {
		this.maxProfanityLevel = maxProfanityLevel;
	}

	public Set<String> getDisallowedWords() {
		return disallowedWords;
	}

	public void setDisallowedWords(Set<String> disallowedWords) {
		this.disallowedWords = disallowedWords;
	}

}
