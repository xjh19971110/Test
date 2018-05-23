import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;

import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NettyClient {
   static EventLoopGroup client=new NioEventLoopGroup();
    public void client(String host,int port) throws InterruptedException, IOException {

        try
        {
            Bootstrap serverBootstrap=new Bootstrap();
            serverBootstrap.group(client).channel((NioSocketChannel.class)).handler(new ChannelInitializer<SocketChannel>() {
                public void initChannel(SocketChannel ch)
                {
                    ChannelPipeline p=ch.pipeline();
                  //  p.addLast("handler",new NettyClientHandler());
                    p.addLast("decoder",new StringDecoder());
                    p.addLast("encoder",new StringEncoder());
                  p.addLast("handler",new NettyClientHandler());
                  p.addLast("handler1",new NettyClient1());



                }
            });
            ChannelFuture cf=serverBootstrap.connect(host,port).sync();
            Channel channel=cf.channel();
            BufferedReader reader=new BufferedReader(new InputStreamReader((System.in)));
            ClientLogin login=new ClientLogin();
            login.Login(channel);

            while(true)
            {
               if(login.flag)
                channel.writeAndFlush(reader.readLine());
            }


        }
        finally {

            client.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        String host="127.0.0.2";
        int port=9999;
        new NettyClient().client(host,port);
    }




}
