package com.ekonuma.springwebsocketpoc.cqrs.event.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ekonuma.springwebsocketpoc.models.events.RoomPatchNameEvent;
import com.ekonuma.springwebsocketpoc.models.messages.ChatMessage;

@Service
public class NotificationEventHandler {

    @Value("${websocket.topic.messages}")
    private String messageDestination;

    @Value("${websocket.topic.room}")
    private String roomDestination;

    private SimpMessagingTemplate template;

    public NotificationEventHandler(SimpMessagingTemplate template) {
        this.template = template;
    }

    @EventListener
    public void updateGreeting(RoomPatchNameEvent event) {
    template.convertAndSend(destination, new ChatMessage(
                String.format("System message: room name changed to %s", event.roomName())));
    template.convertAndSend(roomDestination, new ChatMessage(
                String.format("System message: room name changed to %s", event.roomName())));
    }
}
