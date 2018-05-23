import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
    public void server(int port) throws InterruptedException {
        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup work=new NioEventLoopGroup();
        try
        {
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(boss,work).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                public void initChannel(SocketChannel ch)
                {
                    ch.pipeline().addLast("handler",new NettyServerHandler());
                  ch.pipeline().addLast("handler1",new NettyServerHandler1());
                    //ch.pipeline().addLast("handler2",new NettyServerHandler2());
                    ch.pipeline().addLast("decoder",new StringDecoder());
                    ch.pipeline().addLast("encoder",new StringEncoder());

                   // ch.pipeline().addLast("handler",new NettyServerHandler());
                }
            });
            ChannelFuture cf=serverBootstrap.bind(port).sync();
            cf.channel().closeFuture().sync();
        }
        finally
        {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        int port=9999;
        new NettyServer().server(port);
    }
}
