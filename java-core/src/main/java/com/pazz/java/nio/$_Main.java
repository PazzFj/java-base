package com.pazz.java.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: Peng Jian
 * @create: 2020/1/8 15:38
 * @description: 阻塞 NIO
 */
public class $_Main {

    @Test
    public void server() throws Exception {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8899));

        // socket 通道
        SocketChannel socketChannel = serverChannel.accept();

        // file 通道
        FileChannel fileChannel = FileChannel.open(Paths.get("F:/图片/布鲁克2copy.jpg"),
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);

        // byte 缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 从该通道读取到给定缓冲区的字节序列; 读取的字节数,可能为零,如果通道已达到流出端, 则为-1
        while (socketChannel.read(buffer) != -1) {
            // 翻转这个缓冲区。 该限制设置为当前位置，然后将该位置设置为零。 如果标记被定义，则它被丢弃
            buffer.flip();
            // 从给定的缓冲区向该通道写入一个字节序列
            fileChannel.write(buffer);
            // 清除此缓冲区。 位置设置为零，限制设置为容量，标记被丢弃
            buffer.clear();
        }

        // 在不关闭通道的情况下，关闭读取连接。
        socketChannel.shutdownInput();

        buffer.put("服务端已接收~".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        fileChannel.close();
        socketChannel.close();
        serverChannel.close();
    }

    @Test
    public void client() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8899));

        // 需要发送的 file 通道
        FileChannel fileChannel = FileChannel.open(Paths.get("F:/图片/布鲁克2.jpg"),
                StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        // 在不关闭通道的情况下，为写入而关闭连接
        socketChannel.shutdownOutput();

        int length = 0;
        while ((length = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, length));
            buffer.clear();
        }

        fileChannel.close();
        socketChannel.close();
    }

}
