package com.study.netty.nio;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10).asReadOnlyBuffer();
        buffer.put((byte) 1);
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
