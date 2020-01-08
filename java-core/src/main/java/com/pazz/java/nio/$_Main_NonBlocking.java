package com.pazz.java.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: 彭坚
 * @create: 2020/1/8 20:21
 * @description: NIO 非阻塞式
 */
public class $_Main_NonBlocking {

    @Test
    public void server() throws Exception {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.configureBlocking(false);

        serverChannel.bind(new InetSocketAddress(8899));

        // 创建选择器
        Selector selector = Selector.open();

        // SelectionKey.OP_ACCEPT 操作集位用于 socket 接收操作
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();

                // 测试此密钥的通道是否已准备好接收新的 socket 连接
                if (selectionKey.isAcceptable()) {

                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    // SelectionKey.OP_READ 读操作的操作位
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    // 测试此密钥的频道是否可以阅读
                } else if (selectionKey.isReadable()) {
                    // 返回创建此键的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int length;
                    while ((length = socketChannel.read(buffer)) != -1) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, length));
                        buffer.clear();
                    }
                }
            }
            keyIterator.remove();

        }

    }


    @Test
    public void client() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8899));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("客户端: send~~".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();

        socketChannel.close();
    }

}
