package com.arun.ace.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class CustomChannelInterceptor  implements ChannelInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomChannelInterceptor.class);

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
    	 StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
         StompCommand command = accessor.getCommand();
         logger.info(accessor.getSessionId() +"===" +command);
        return message;
    }

	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
		// TODO Auto-generated method stub
		ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
	}

	@Override
	public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
		// TODO Auto-generated method stub
		ChannelInterceptor.super.afterReceiveCompletion(message, channel, ex);
	}
}