package com.pazz.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: Peng Jian
 * @create: 2020/1/7 9:04
 * @description:
 */
public class TestServer {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8899));

        SocketChannel socketChannel = serverSocketChannel.accept();

        FileChannel fileChannel = FileChannel.open(Paths.get("E:/download/IO_Stream3.png"),
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 服务端读取缓存区, 不为空(-1). 继续读取缓存区
        int len;
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            System.out.println("读取长度: " + len);
            // 当调用channel的read方法后，buffer处于被channel写入的状态，处于写模式
            // 调用下边这句话后，buffer就要切换状态到读模式，此时用户可从buffer中取出数据。
            byteBuffer.flip();
            byteBuffer.clear();
            fileChannel.write(byteBuffer);
        }

        System.out.println("receive");
        socketChannel.shutdownOutput();
        fileChannel.close();
        socketChannel.close();
        serverSocketChannel.close();

    }

}
