//package com.arun.ace.configuration;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//@ComponentScan
//public class PeerJSWebSocketHandler extends TextWebSocketHandler {
//
//    private static final Logger logger = LoggerFactory.getLogger(PeerJSWebSocketHandler.class);
//
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
//        logger.debug("Received message: " + message.getPayload());
//        session.sendMessage(message);
//    }
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        logger.debug("Connection established: " + session.getId());
//        System.out.println(session.toString());
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        logger.debug("Connection closed: " + session.getId());
//        System.out.println(session.toString());
//    }
//
//}
