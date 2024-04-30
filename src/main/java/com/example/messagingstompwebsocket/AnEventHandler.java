package com.example.messagingstompwebsocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.example.messagingstompwebsocket.MessageService.AnEvent;

@Service
public class AnEventHandler {

    private WebSocketHandler webSocketHandler;

    @EventListener
    public void updateGreeting(AnEvent ignore) {
        // webSocketHandler.getSessions();
        // controller.greeting();
    }
}
