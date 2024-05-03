package com.ekonuma.springwebsocketpoc.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.ekonuma.springwebsocketpoc.models.messages.ChatMessage;

@Service
public class NotificationService {

    @Value("${websocket.topic.messages}")
    private String destination;

    private SimpMessagingTemplate template;
    private SimpUserRegistry registry;
    private int userCount;

    public NotificationService(SimpMessagingTemplate template, SimpUserRegistry registry) {
        this.template = template;
        this.registry = registry;
    }

    @Scheduled(fixedDelay = 10000)
    public void sendConnectionNotification() {
        template.convertAndSend(destination, new ChatMessage(
                String.format("System message: user count is %d", userCount)));
    }

    @EventListener
    public void sessionDisconnectEventHandling(SessionDisconnectEvent disconnection) {
        userCount--;
        sendConnectionNotification();
    }

    @EventListener
    public void sessionConnectionEventHandling(SessionConnectedEvent connection) {
        userCount++;
        sendConnectionNotification();
    }
}
