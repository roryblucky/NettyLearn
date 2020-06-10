package com.study.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemoWithFile {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/test.txt");
        FileChannel fc = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("Initialize", buffer);
        fc.read(buffer);
        output("read", buffer);

        buffer.flip();
        output("flip", buffer);

        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            System.out.println((char) b);
        }
        output("get", buffer);

        buffer.clear();
        output("clear", buffer);

        inputStream.close();
    }


    public static void output(String step, Buffer buffer) {
        System.out.println(step + " : ");
        System.out.print("capacity: " + buffer.capacity() + ", ");
        System.out.print("position: " + buffer.position() + ", ");
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }
}
