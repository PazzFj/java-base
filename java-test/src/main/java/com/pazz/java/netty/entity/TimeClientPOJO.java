package com.pazz.java.netty.entity;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: 彭坚
 * @create: 2019/1/16 23:01
 * @description:
 */
public class TimeClientPOJO {

    public static void main(String[] args) {
        String host = "127.0.0.1";            // ip
        int port = 8080;                    // 端口
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();            // 与ServerBootstrap类似
            b.group(workerGroup);                    // 客户端不需要boss worker
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);    // 客户端的socketChannel没有父亲
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    // POJO
                    socketChannel.pipeline().addLast(new TimeDecoderPOJO(), new TimeClientHandlerPOJO());
                }
            });

            // 启动客户端，客户端用connect连接
            ChannelFuture f = b.connect(host, port).sync();

            // 等待连接关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}
