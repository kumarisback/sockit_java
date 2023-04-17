package com.arun.ace.eventlistner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


////This can be used to get event data of websocket and there are many event like SessionDisconnectEvent
public class WebSocketEventListener implements ApplicationListener<SessionDisconnectEvent> {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        logger.info("User disconnected: {}", event.toString());
    }
}
