package com.example.messagingstompwebsocket;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final MessageService messageService;

    public WebSocketHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        String receivedMessage = (String) message.getPayload();
        try {
            session.sendMessage(new TextMessage("Received: " + receivedMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // messageService.add
        // sessions.add(session.get, session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // sessions.remove(session);

    }
}