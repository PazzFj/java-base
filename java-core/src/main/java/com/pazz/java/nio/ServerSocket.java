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
public class ServerSocket {

    public static void send() throws Exception {
        // 1、打开管道并绑定端口
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8899));

        // 2、设置文件内管道
        FileChannel fileChannel = FileChannel.open(Paths.get("f:/images/Alienware壁纸.jpg"), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);

        SocketChannel channel = socketChannel.accept();
        // 3、设置缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

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
