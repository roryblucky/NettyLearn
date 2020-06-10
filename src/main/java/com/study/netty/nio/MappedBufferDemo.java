package com.study.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MappedBufferDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("src/main/resources/mappedFile.txt", "rw");

        FileChannel fc = file.getChannel();

        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, 2048);

        buffer.put("Summer ".getBytes());

        file.close();
    }
}
