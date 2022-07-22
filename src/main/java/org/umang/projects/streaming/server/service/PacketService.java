package org.umang.projects.streaming.server.service;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.springframework.stereotype.Service;
import org.umang.projects.streaming.server.dto.Packet;

@Service
public class PacketService {
  public Packet getTimeFrame(final long position) {
    int len = 1024 * 10;  // 1024 bytes
    byte [] data = new byte[len];
    try (
        RandomAccessFile fileStream = new RandomAccessFile(
            "videoplayback.mp4", "r")
    ) {
      long fileLength = fileStream.length();
      if (position >= fileLength) {
        throw new IOException("no content");
      }
      fileStream.seek(position);
      fileStream.read(data, 0, len);
      return new Packet(data, fileStream.getFilePointer());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
