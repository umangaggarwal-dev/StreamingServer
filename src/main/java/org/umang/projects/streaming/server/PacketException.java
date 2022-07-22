package org.umang.projects.streaming.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PacketException {
  @ExceptionHandler(value = {RuntimeException.class})
  public ResponseEntity<HttpStatus> noPacketFound() {
    return ResponseEntity.noContent().build();
  }
}
