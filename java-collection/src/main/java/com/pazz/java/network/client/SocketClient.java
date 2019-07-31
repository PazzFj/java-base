package com.pazz.java.network.client;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SocketClient {

    @Test
    public void test1() throws IOException {
        SocketChannel clientCha = SocketChannel.open(new InetSocketAddress(8899));
        FileChannel fileCha = FileChannel.open(Paths.get("f:/images/h9.jpg"), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileCha.read(byteBuffer) != -1) {
            byteBuffer.flip();
            clientCha.write(byteBuffer);
            byteBuffer.clear();
        }
        clientCha.shutdownOutput();
        int len = 0;
        while ((len = clientCha.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(), 0, len));
            byteBuffer.clear();
        }
        fileCha.close();
        clientCha.close();
    }

    @Test
    public void test2() throws IOException {
        SocketChannel clientC = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8899));
        clientC.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("傻逼是你..".getBytes());
        byteBuffer.flip();
        clientC.write(byteBuffer);
        byteBuffer.clear();
        clientC.close();
    }
}
