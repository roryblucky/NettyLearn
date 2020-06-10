package com.study.netty.nio;

import java.nio.IntBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for (int i = 0; i < intBuffer.capacity(); ++i) {
            int j = 2 * (i + 1);
            intBuffer.put(j);
        }

        intBuffer.flip();

        while(intBuffer.hasRemaining()) {
            int result = intBuffer.get();

            System.out.println(result);
            System.out.println("\t");
        }
    }
}
