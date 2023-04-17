package com.arun.ace.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket

public class Config   implements WebSocketMessageBrokerConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		logger.info("registering STOMP endpoints");
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}
	
	
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		WebSocketMessageBrokerConfigurer.super.configureClientInboundChannel(registration);
		registration.interceptors(new CustomChannelInterceptor());
		logger.info("message--"+registration.toString());
		
	}


	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		WebSocketMessageBrokerConfigurer.super.configureClientOutboundChannel(registration);
		logger.info("message---"+registration.toString());

	}


	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
		// TODO Auto-generated method stub
		WebSocketMessageBrokerConfigurer.super.configureWebSocketTransport(registry);
	}


	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		// TODO Auto-generated method stub
		return WebSocketMessageBrokerConfigurer.super.configureMessageConverters(messageConverters);
	}


	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		logger.info("registering STOMP endpoints");
		registry.addEndpoint("/entry").setAllowedOriginPatterns("*").withSockJS();
		registry.addEndpoint("/entry/peerjs").setAllowedOriginPatterns("*").withSockJS();
	}
	
}
