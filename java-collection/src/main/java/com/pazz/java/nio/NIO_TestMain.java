package com.pazz.java.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class NIO_TestMain {

    /**
     * BIO   同步 阻塞
     * NIO   同步 非阻塞
     * AIO   异步 非阻塞
     */
    public static void main(String[] args) throws Exception {
        FileChannel channel = null;         // 文件通道

        ByteBuffer byteBuffer = null;  // 缓存区  ByteBuffer.allocateDirect(10);
//        FileChannel 文件通道  DatagramChannel 数据报文通道  SocketChannel  连接通道  ServerSocketChannel 服务器通道

//        ByteBuffer、 CharBuffer、 DoubleBuffer、 FloatBuffer、 IntBuffer、 LongBuffer、 ShortBuffer

        // 选择器允许单个线程处理多个通道
        Selector selector = null;       // 选择器

        File file = new File("E://file/context.txt");

        RandomAccessFile raf = new RandomAccessFile("E://file/context.txt", "rw");
        channel = raf.getChannel();

        byteBuffer = ByteBuffer.allocate(1024);

        int bytesRead = channel.read(byteBuffer);
        while(bytesRead != -1){
            byteBuffer.flip();  // 注意buf.flip()的调用，首先读入一个缓冲区，然后将内容弹出，然后读出数据。

            while(byteBuffer.hasRemaining()){
                System.out.print(byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = channel.read(byteBuffer);
        }

        channel.close();

//        BufferedReader br = new BufferedReader(new FileReader(file));
//        br.readLine()

    }


}
