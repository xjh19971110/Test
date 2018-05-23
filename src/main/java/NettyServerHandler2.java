import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler2 extends ChannelInboundHandlerAdapter {
    @Override
    public void  channelActive(ChannelHandlerContext ctx)
    {
        System.out.println(10);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg)
    {
        ;
    }
}
