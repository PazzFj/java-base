package com.pazz.java.netty.entity;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2019/1/16 21:00
 * @description: 解码器
 */
public class TimeDecoderPOJO extends ByteToMessageDecoder {

    /**
     * 有新数据接收时调用
     * 为防止分包现象，先将数据存入内部缓存，到达满足条件之后再进行解码
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 4) {
            return;
        }

        // list添加对象则表示解码成功
        list.add(new Time(byteBuf.readUnsignedInt()));
    }
}
