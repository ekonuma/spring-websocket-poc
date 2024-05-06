package com.ekonuma.springwebsocketpoc.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.ekonuma.springwebsocketpoc.models.messages.ChatMessage;
import com.ekonuma.springwebsocketpoc.models.messages.UserSendMessage;

@Controller
public class ChatWebsocketController {

	@MessageMapping("/send-message")
	@SendTo("/topic/messages")
	public ChatMessage greeting(SimpMessageHeaderAccessor headerAccessor, UserSendMessage message) {
		return new ChatMessage(String.format("%s: %s", headerAccessor.getSessionId(), message.name()));
	}
}
