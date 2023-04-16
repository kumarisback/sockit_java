package com.arun.ace.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
public class Config   implements WebSocketMessageBrokerConfigurer , WebSocketConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		logger.info("registering STOMP endpoints");
		config.enableSimpleBroker("/topic");
		
		config.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		logger.info("registering STOMP endpoints");
		registry.addEndpoint("/entry").setAllowedOriginPatterns("*").withSockJS();
		registry.addEndpoint("/entry/peerjs").setAllowedOriginPatterns("*").withSockJS();
	}

	

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addHandler(new PeerJSWebSocketHandler(), "/signaling");
	}
	 

	  
}
