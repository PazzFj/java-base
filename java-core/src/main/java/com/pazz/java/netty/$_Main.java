package com.pazz.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author: Peng Jian
 * @create: 2020/1/9 14:41
 * @description: netty 使用
 */
public class $_Main {

    @Test
    public void serverNetty() throws Exception {

        // 用来接收进来的连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        // 用来处理已经被接收的连接，一旦bossGroup接收到连接，就会把连接信息注册到workerGroup上
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        // nio服务的启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        // 配置nio服务参数
        ChannelFuture cf = serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)  // 说明一个新的Channel如何接收进来的连接
                .localAddress(8899)
                .option(ChannelOption.SO_BACKLOG, 1024) // 标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度
                .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel sc) throws Exception { // NioServerSocketChannel

                        // 处理接收到的请求 DefaultChannelPipeline
                        sc.pipeline().addLast(new SimpleChannelInboundHandler<Object>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf bb = (ByteBuf) msg;
                                // 创建一个和buf同等长度的字节数组
                                byte[] reqByte = new byte[bb.readableBytes()];
                                // 将buf中的数据读取到数组中
                                bb.readBytes(reqByte);
                                String reqStr = new String(reqByte, Charset.forName("utf-8"));
                                System.err.println("server 接收到客户端的请求： " + reqStr);
                                String respStr = new StringBuilder("来自服务器的响应").append(reqStr).append("$_").toString();

                                // 返回给客户端响应                                                                                                                                                       和客户端链接中断即短连接，当信息返回给客户端后中断
                                ctx.writeAndFlush(Unpooled.copiedBuffer(respStr.getBytes()));
                            }
                        });

                    }
                })
                .bind().sync();

        // 等待服务端口的关闭；在这个例子中不会发生，但你可以优雅实现；关闭你的服务
        cf.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    @Test
    public void clientNetty() throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        Channel channel = bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer() {
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect("127.0.0.1", 8899)
                .sync()
                .channel();

        int length = 0;
        while (++length <= 10) {
            channel.writeAndFlush(new Date() + ": two");
            Thread.sleep(2000);
        }

        channel.closeFuture().sync();

    }

}
