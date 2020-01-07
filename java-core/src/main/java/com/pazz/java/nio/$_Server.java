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
 * @description: 服务端 阻塞 nio
 */
public class $_Server {

    public static void main(String[] args) throws Exception {
        receiveBlockNIOServer("F:/images/txt.png");
    }

    public static void receiveBlockNIOServer(String filePath) throws Exception {
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
            // 当调用channel的read方法后，buffer处于被channel写入的状态，处于写模式
            // 调用下边这句话后，buffer就要切换状态到读模式，此时用户可从buffer中取出数据。
            fileChannel.write(byteBuffer); //把缓存写入文件管道
            byteBuffer.clear();
        }


        byteBuffer.put("图片已发送".getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        channel.close();
        fileChannel.close();

        socketChannel.close();

    }

}
