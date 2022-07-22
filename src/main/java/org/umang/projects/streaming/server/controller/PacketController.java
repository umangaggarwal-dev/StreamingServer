package org.umang.projects.streaming.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.umang.projects.streaming.server.dto.Packet;
import org.umang.projects.streaming.server.service.PacketService;

@RestController
@RequestMapping("/api/v1/packet")
public class PacketController {

  private final PacketService packetService;

  public PacketController(final PacketService packetService) {
    this.packetService = packetService;
  }

  @GetMapping(value = "/play", produces = "video/mp4")
  public ResponseEntity<byte[]> getPacket(
      @RequestParam(value = "start", defaultValue = "0") final long start
  ) {
    Packet packet = packetService.getTimeFrame(start);
    return ResponseEntity.status(HttpStatus.OK)
        .header("next", Long.toString(packet.getNext()))
        .body(packet.getData());
  }
}
