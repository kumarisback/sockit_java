package com.arun.ace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;


@SpringBootApplication
public class AceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceApplication.class, args);
	}
	

}
