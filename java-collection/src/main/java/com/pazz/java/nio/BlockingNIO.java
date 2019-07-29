package com.pazz.java.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: 彭坚
 * @create: 2018/12/15 22:57
 * @description: NIO 阻塞式与非阻塞式网络通信     non blocking NIO
 */
public class BlockingNIO {

    @Test
    public void test() throws Exception {
//        Path var3 = Paths.get("f:/img/jay2.jpg"); //创建目录
//        Files.createDirectories(var3);
//        System.out.println(var3);
//        byte[] bytes = new byte[1024];
//        Files.write(var3, bytes);
    }

    //阻塞式的
    @Test
    public void client() throws IOException {
        //创建通道
        FileChannel open = FileChannel.open(Paths.get("f:/img/jay.jpg"), StandardOpenOption.READ);
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //创建socket通道
        SocketChannel open2 = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        //读取本地文件，并发送到服务端
        while (open.read(buffer) != -1) {
            // 从buffer弹出数据
            buffer.flip();
            open2.write(buffer);
            buffer.clear();
        }
        // 在不关闭通道的情况下，关闭用于写入的连接
        open2.shutdownOutput();
        //获取服务端反馈
        int len = 0;
        while ((len = open2.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }
        open.close();
        open2.close();
    }

    //阻塞式的
    @Test
    public void server() throws IOException {
        // 获取通道
        FileChannel open = FileChannel.open(Paths.get("f:/img/jaycopy.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ServerSocketChannel open2 = ServerSocketChannel.open();
        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //绑定连接
        open2.bind(new InetSocketAddress(9988));
        //获取客户端连接的通道
        SocketChannel accept = open2.accept();
        //接收客户端的数据，并保存到本地
        while (accept.read(byteBuffer) != -1) {
            byteBuffer.flip();
            open.write(byteBuffer);
            byteBuffer.clear();
        }

        //发送反馈给客户端
        byteBuffer.put("图片收到了".getBytes());
        byteBuffer.flip();
        accept.write(byteBuffer);
        accept.close();
        open.close();
        open2.close();
    }


}
