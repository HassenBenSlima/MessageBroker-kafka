package com.chat.chatProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.chat.profanity_checker.ProfanityChecker;
import com.chat.profanity_checker.SessionProfanity;

@Configuration
@EnableConfigurationProperties(ChatProperties.class)
public class ChatConfig {

	@Autowired
	private ChatProperties chatProperties;

	@Bean
	@Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
	@Description("Keeps track of the level of profanity of a websocket session")
	public SessionProfanity sessionProfanity() {
		return new SessionProfanity(chatProperties.getMaxProfanityLevel());
	}

	@Bean
	@Description("Utility class to check the number of profanities and filter them")
	public ProfanityChecker profanityFilter() {
		ProfanityChecker checker = new ProfanityChecker();
		checker.setProfanities(chatProperties.getDisallowedWords());
		return checker;
	}

}
