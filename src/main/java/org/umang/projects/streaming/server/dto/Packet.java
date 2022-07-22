package org.umang.projects.streaming.server.dto;

public class Packet {
  private final byte[] data;
  private final long next;

  public Packet(final byte[] data, final long next) {
    this.data = data;
    this.next = next;
  }

  public byte[] getData() {
    return data;
  }

  public long getNext() {
    return next;
  }
}
