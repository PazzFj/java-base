package com.pazz.java.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: 彭坚
 * @create: 2018/12/16 23:32
 * @description:
 */
public class NonBlockingNIO {

    //非阻塞式的
    @Test
    public void client2() throws IOException {
        //1. 获取通道
        SocketChannel clientSoc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        //2. 切换非阻塞模式
        clientSoc.configureBlocking(false);
        //3. 分配指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //4. 发送数据给服务端
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String next = sc.next();
//        }
        allocate.put("idea what???? ".getBytes());
        allocate.flip();
        clientSoc.write(allocate);
        allocate.clear();
        sc.close();
        //5. 关闭通道
        clientSoc.close();
    }

    //非阻塞式的
    @Test
    public void server2() throws IOException {
        //1. 获取通道
        ServerSocketChannel serSoc = ServerSocketChannel.open();
        //2. 切换非阻塞模式
        serSoc.configureBlocking(false);
        //3. 绑定连接
        serSoc.bind(new InetSocketAddress(9988));
        //4. 获取选择器
        Selector selector = Selector.open();
        //5. 将通道注册到选择器上, 并且指定“监听接收事件”
        serSoc.register(selector, SelectionKey.OP_ACCEPT);
        //6. 轮询式的获取选择器上已经“准备就绪”的事件
        while (selector.select() > 0) {
            //7. 获取当前选择器中所有注册的“选择键(已就绪的监听事件)”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                //8. 获取准备“就绪”的是事件
                SelectionKey sk = iterator.next();
                //9. 判断具体是什么事件准备就绪
                if (sk.isAcceptable()) {
                    //10. 若“接收就绪”，获取客户端连接
                    SocketChannel sChannel = serSoc.accept();
                    //11. 切换非阻塞模式
                    sChannel.configureBlocking(false);
                    //12. 将该通道注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    //13. 获取当前选择器上“读就绪”状态的通道
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    //14. 读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
            }
            //15. 取消选择键 SelectionKey
            iterator.remove();
        }
    }

}
