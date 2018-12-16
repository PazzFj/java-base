package com.pazz.java.core.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: 彭坚
 * @create: 2018/12/14 23:47
 * @description:
 */
public class TestChannel {

    /**
     * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
     *
     * 二、通道的主要实现类
     * 	java.nio.channels.Channel 接口：
     * 		|--FileChannel
     * 		|--SocketChannel
     * 		|--ServerSocketChannel
     * 		|--DatagramChannel
     *
     * 三、获取通道
     * 1. Java 针对支持通道的类提供了 getChannel() 方法
     * 		本地 IO：
     * 		FileInputStream/FileOutputStream
     * 		RandomAccessFile
     *
     * 		网络IO：
     * 		Socket
     * 		ServerSocket
     * 		DatagramSocket
     *
     * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
     * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
     *
     * 四、通道之间的数据传输
     * transferFrom()
     * transferTo()
     *
     * 五、分散(Scatter)与聚集(Gather)
     * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
     * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
     *
     * 六、字符集：Charset
     * 编码：字符串 -> 字节数组
     * 解码：字节数组  -> 字符串
     */
    public static void main(String[] args) throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("f:/img/jay.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("f:/img/jaycopy.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        MappedByteBuffer inMappedBuf =  inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf =  outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] b = new byte[inMappedBuf.limit()];
        inMappedBuf.get(b);
        outMappedBuf.put(b);
        inChannel.close();
        outChannel.close();

        System.out.println("-----------------------------------------------");
        RandomAccessFile randomAccessFile = new RandomAccessFile("f:/test.txt", "rw");
        //得到通道
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] byteBuffers = {buffer1, buffer2};
        channel.read(byteBuffers);
        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBuffer.flip();
        }
        System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));
        System.out.println("-----------------------------------------------");
        System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit()));

        Charset charset = Charset.forName("utf-8");
        System.out.println(charset.newEncoder());

    }

}
