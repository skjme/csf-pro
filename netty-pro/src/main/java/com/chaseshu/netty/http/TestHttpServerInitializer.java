package com.chaseshu.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        // 向管理加入处理器

        // 得到管道
        ChannelPipeline pipeline = ch.pipeline();

        // 1  netty 提供 http 编码解码器 codec (coder decoder)
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        // 2 增加一个自定义的handler
        pipeline.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());

    }
}
