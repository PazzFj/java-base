package com.pazz.java.test.netty.entity;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: 彭坚
 * @create: 2019/1/16 21:02
 * @description: 客户端数据处理类
 */
public class TimeClientHandlerPOJO extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 直接将信息转换成Time类型输出即可
        Time time = (Time) msg;
        System.out.println(time);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
