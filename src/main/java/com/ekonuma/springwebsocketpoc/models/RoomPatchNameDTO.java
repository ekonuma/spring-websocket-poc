package com.ekonuma.springwebsocketpoc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RoomPatchNameDTO(@JsonProperty("room-name") String roomName) {

}
