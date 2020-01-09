package com.pazz.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.Date;

/**
 * @author: Peng Jian
 * @create: 2020/1/9 14:41
 * @description: netty 使用
 */
public class $_Main {

    @Test
    public void serverNetty() throws Exception {

        // 创建mainReactor
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();

        // 创建工作线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosGroup, workerGroup)   // 组装NioEventLoopGroup
                .channel(NioServerSocketChannel.class)  // 设置channel类型为NIO类型
//                .localAddress(new InetSocketAddress(8000))
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder(), new SimpleChannelInboundHandler<Object>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                            }
                        });

                    }
                })
                .bind(8000);
    }

    @Test
    public void clientNetty() throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        Channel channel = bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer() {
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect("127.0.0.1", 8000)
                .channel();

        while (true) {
            channel.writeAndFlush(new Date() + ": two");
            Thread.sleep(2000);
        }
    }

}
