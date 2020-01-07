package com.pazz.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: 彭坚
 * @create: 2020/1/6 21:09
 * @description: 服务端 nio
 */
public class Server {

    public static void main(String[] args) throws Exception {
        send("E:/download/IO_Stream3.png");
    }

    public static void send(String filePath) throws Exception {
        // 1、开启服务端绑定端口
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8899));

        // 2、创建管道副本 ( FileChannel )
        FileChannel fileChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);

        // 3、创建缓存区 ( ByteBuffer )
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 4、创建连接管道
        SocketChannel channel = socketChannel.accept();

        // 5、连接管道循环读取缓存区
        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip(); //弹
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        byteBuffer.put("图片已发送".getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);


        channel.close();
        socketChannel.close();


    }

}
