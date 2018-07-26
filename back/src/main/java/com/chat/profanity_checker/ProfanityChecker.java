package com.chat.profanity_checker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfanityChecker {

	private Set<String> profanities = new HashSet<>();
	/**
	 * 
	 * @param message
	 * @return le nombre de mot interdit
	 */
	public long getMessageProfanity(String message) {
		return Arrays.stream(message.split(" ")) //
				.filter(word -> profanities.contains(word)) //
				.count();
	}

	/**
	 * supprimer les mot interdit
	 * @param message
	 * @return
	 */
	public String filter(String message) {
		return Arrays.stream(message.split(" "))//
				.filter(word -> !profanities.contains(word)) //
				.collect(Collectors.joining(" "));
	}

	public Set<String> getProfanities() {
		return profanities;
	}

	public void setProfanities(Set<String> profanities) {
		this.profanities = profanities;
	}
}
