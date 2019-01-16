package com.pazz.java.netty.entity;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: 彭坚
 * @create: 2019/1/16 9:40
 * @description:
 */
public class TimeEncoderPOJO extends MessageToByteEncoder<Time> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Time msg, ByteBuf out) throws Exception {
        out.writeInt((int) msg.value());
    }
}
