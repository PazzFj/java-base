package net.pazz.base.net.server;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class SocketServer {

    @Test
    public void test1() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8899));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel fileCha = FileChannel.open(Paths.get("f:/images/h9_copy.jpg"), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        SocketChannel socketCha = serverSocketChannel.accept();
        while (socketCha.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileCha.write(byteBuffer);
            byteBuffer.clear();
        }
        //发送反馈给客户端
        byteBuffer.put("图片收到了".getBytes());
        byteBuffer.flip();
        socketCha.write(byteBuffer);
        socketCha.close();
        fileCha.close();
        serverSocketChannel.close();
    }

    @Test
    public void test2() throws IOException {
        ServerSocketChannel serverC = ServerSocketChannel.open();
        serverC.configureBlocking(false);
        serverC.bind(new InetSocketAddress(8899));
        Selector selector = Selector.open();
        serverC.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();
                if (sk.isAcceptable()) {
                    SocketChannel accept = serverC.accept();
                    if (accept != null) {
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ);
                    }
                } else if (sk.isReadable()) {
                    SocketChannel readable = (SocketChannel) sk.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = readable.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }
                }
            }
            iterator.remove();
        }
    }
}
