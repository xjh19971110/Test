import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    boolean flag1=true;
    String receiveMsg;
    String sendMsg;
    @Override
    public void handlerAdded(ChannelHandlerContext ctx)
    {




    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg)
    {


        if(flag1)
        {
             receiveMsg=(String)msg;
            if(receiveMsg.equals("用户名不存在")||receiveMsg.equals("密码错误"))
            {
                System.out.println("用户名不存在或密码错误");
                ctx.channel().closeFuture();
                NettyClient.client.shutdownGracefully();
            }
            else if(receiveMsg.equals("欢迎登陆"))
            {
                System.out.println("欢迎登陆");
                ClientLogin.flag=true;
                flag1=false;

            }
        }

        else
        {
            if(receiveMsg.equals("成功退出"))
            {
                ctx.channel().closeFuture();
                NettyClient.client.shutdownGracefully();
            }
            else
                {
                    if()
                receiveMsg = (String) msg;
                System.out.println(receiveMsg);
                }
        }



    }

}
