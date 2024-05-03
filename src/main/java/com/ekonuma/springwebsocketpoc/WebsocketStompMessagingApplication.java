package com.ekonuma.springwebsocketpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebsocketStompMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketStompMessagingApplication.class, args);
	}
}
