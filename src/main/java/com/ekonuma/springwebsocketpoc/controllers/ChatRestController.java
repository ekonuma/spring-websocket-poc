package com.ekonuma.springwebsocketpoc.controllers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekonuma.springwebsocketpoc.models.RoomPatchNameDTO;
import com.ekonuma.springwebsocketpoc.models.events.RoomPatchNameEvent;

@RestController
@RequestMapping("/room")
public class ChatRestController {

  private ApplicationEventPublisher publisher;

  public ChatRestController(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @PatchMapping("/name")
  public ResponseEntity<Void> greeting(@RequestBody RoomPatchNameDTO roomNamePatchDTO) {
    publisher.publishEvent(new RoomPatchNameEvent(roomNamePatchDTO.roomName()));
    return ResponseEntity.accepted().build();
  }
}
