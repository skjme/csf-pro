package com.chaseshu.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {

        // 事件循环组
        EventLoopGroup group = new NioEventLoopGroup();

        try {

            // 创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();

            // 设置参数
            bootstrap.group(group) // 设置线程组
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHanndler());
                        }
                    });

            System.out.println("客户端 OK。。。");
            // 连接服务器
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 6668).sync();

            // 给关闭通道进行通道
            cf.channel().closeFuture().sync();

        }finally {

            group.shutdownGracefully();
        }

    }
}
