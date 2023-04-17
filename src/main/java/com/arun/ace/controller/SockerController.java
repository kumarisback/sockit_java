package com.arun.ace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.arun.ace.Entity.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SockerController {

	private static final Logger logger = LoggerFactory.getLogger(SockerController.class);
	
	@MessageMapping("/chat")
	@SendTo("/topic")
	public ResponseEntity<String> greeting(@Payload Message message) throws Exception {
		logger.info("registering STOMP endpoints");
		ObjectMapper objectMapper  = new ObjectMapper();
		String jsonMessage = objectMapper.writeValueAsString(message);
		return ResponseEntity.ok(jsonMessage);

//		return new Message(message.getId(),message.getUsername(),message.getMessage());
	}
	
//	@MessageMapping("/chat/{id}")
//	@SendTo("/topic/{id}")
//	public ResponseEntity<String> greeting1(@Payload Message message, @DestinationVariable int id) throws Exception {
//		logger.info("registering STOMP endpoints");
//		ObjectMapper objectMapper  = new ObjectMapper();
//		String jsonMessage = objectMapper.writeValueAsString(message);
//		return ResponseEntity.ok(jsonMessage);
//
////		return new Message(message.getId(),message.getUsername(),message.getMessage());
//	}
//	
	@MessageMapping("/peerjs/{id}")
	@SendTo("/topic/{id}")
	public ResponseEntity<String> peer(@Payload Message message, @DestinationVariable String id) throws Exception {
		logger.info("registering STOMP endpoints");
		ObjectMapper objectMapper  = new ObjectMapper();
		String jsonMessage = objectMapper.writeValueAsString(message);
		return ResponseEntity.ok(jsonMessage);

	}
	
//	@MessageMapping("/peerjs/video/{id}")
//	@SendTo("/topic/video/{id}")
//	public ResponseEntity<String> video(@Payload Message message, @DestinationVariable String id) throws Exception {
//		logger.info("registering STOMP endpoints");
//		ObjectMapper objectMapper  = new ObjectMapper();
//		String jsonMessage = objectMapper.writeValueAsString(message);
//		return ResponseEntity.ok(jsonMessage);
//
//	}
}
