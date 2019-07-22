package com.pazz.java.core.io;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @author: 彭坚
 * @create: 2019/1/14 17:30
 * @description:
 */
public class NettyClient {

    public static void main(String[] args) throws Exception {
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
