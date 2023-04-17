package com.arun.ace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arun.ace.eventlistner.WebSocketEventListener;


@SpringBootApplication
public class AceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceApplication.class, args);
	}
	@Bean
	public WebSocketEventListener webSocketEventListener() {
	    return new WebSocketEventListener();
	}


}
