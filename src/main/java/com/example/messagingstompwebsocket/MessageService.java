package com.example.messagingstompwebsocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class MessageService {

    @Autowired
    private ApplicationEventPublisher publisher;

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Scheduled(fixedDelay = 5000)
    public void publishAnEvent() {
        System.out.println("Sending event");
        publisher.publishEvent(new AnEvent());
    }

    public class AnEvent {

    }
}
