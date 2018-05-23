import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
   static FileName fileName=new FileName();
   static Set<String> iterator=fileName.novel.keySet();
    public static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static File1 ef=new File1();
   // User user1=new User();
   static boolean flag3=false;
    String receiveMsg;
    String sendMsg;


    @Override
    public void handlerAdded(ChannelHandlerContext ctx)
    {
        flag3=true;
        //System.out.println(2);





       // Channel inComing=ctx.channel();
        //for(Channel channel:channels)
        //System.out.println(2);

    }
   @Override
    public void handlerRemoved(ChannelHandlerContext ctx)
   {
       ;
   }
   @Override
   public void channelActive(ChannelHandlerContext ctx)
   {

       //System.out.println(3);
   }
   @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws UnsupportedEncodingException, InterruptedException {
       //System.out.println(msg);
       //receiveMsg=(String)msg;
       //System.out.println(msg);
      // System.out.println(5);
       Channel inComing=ctx.channel();
       ByteBuf buf=(ByteBuf)msg;
       byte[] bytes=new byte[buf.readableBytes()];
       buf.readBytes(bytes);
       receiveMsg=new String(bytes);
      // System.out.println(receiveMsg);
      // receiveMsg.replace("\r","");
       if(flag3)
       {
           String[] ss=new String[3];
           ss=receiveMsg.split(" ",2);
           String user_Name=ss[0];
           String passWord=ss[1];
           sendMsg=Login.Verification(user_Name,passWord,inComing);
          // System.out.println(user_Name+passWord);
           //System.out.println(sendMsg);
           if(sendMsg.equals("欢迎登陆"))
           {
               channelGroup.add(inComing);
               for(Channel channel:channelGroup)
               {
                   if(channel!=inComing)
                   {
                       channel.writeAndFlush(User.ip.get(inComing)+"走进了房间");
                   }
               }

           }
           inComing.writeAndFlush(sendMsg);
           flag3=false;



       }


       else
       {

        //  System.out.println(receiveMsg);
          //String a=new String("退出");
          // receiveMsg.replace("\r","");
           if(receiveMsg.equals("退出"))
           {
              // System.out.println(1);
              sendMsg= LoginOut.Cancellation(User.ip.get(inComing),inComing);
               channelGroup.remove(inComing);
               inComing.writeAndFlush(sendMsg);
               for(Channel channel:channelGroup)
               {
                   if(channel!=inComing)
                   {
                       channel.writeAndFlush(User.ip.get(inComing)+"离开了房间");
                   }
               }

           }

           if(receiveMsg.equals("下载"))
           {
              // fileName=new FileName();
               //System.out.println(1);
              for(String n:iterator)
              {
                 // System.out.println(n);
                  inComing.writeAndFlush(n);
                  //System.out.print(n+"\n");
                 sleep(5);
              }



           }

           if(fileName.novel.get(receiveMsg)!=null)
           {
               ef.setFileName(receiveMsg);
              // System.out.println(4);
               ef.setPath(fileName.novel.get(receiveMsg));
               //System.out.println(3);
               ctx.fireChannelActive();
              // ctx.fireChannelRead(msg);
               System.out.println(2);

           }
           if(msg instanceof File1)
           {
               ctx.fireChannelRead(msg);
           }
           else {
               for (Channel channel : channelGroup) {
                   if (channel != inComing) {
                      // System.out.println(receiveMsg);
                       channel.writeAndFlush(User.ip.get(inComing) + ":" + receiveMsg);
                   }
               }
           }
         //  System.out.println(receiveMsg);

          // inComing.writeAndFlush("你好");
       }

      // System.out.println(messages);
     /*  Channel inComing=ctx.channel();


       System.out.println(5);
       if(true)
       {

           System.out.println(6);
           System.out.println(7);
           String[] ss=new String[20];
           System.out.println(8);
          // receiveMsg=msg.toString();
          // System.out.println(receiveMsg);
          // receiveMsg=(String)msg;
         //  System.out.println(receiveMsg);
         //  System.out.println(9);
           System.out.println(msg);
          ss=msg.split(" ",2);
           String user_Name=ss[0];
           String passWord=ss[1];
           System.out.println(user_Name+passWord);
          //sendMsg= Login.Verification(user_Name,passWord);
          //inComing.writeAndFlush(sendMsg);
          System.out.println(4);
          flag3=false;


       }
       else
       {
           inComing.writeAndFlush("你好");
       }




       //inComing.writeAndFlush("你好");

      // ctx.fireChannelRead(msg);*/


   }
   @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause)
   {
       Channel inComing=ctx.channel();
       System.out.println(inComing+"出现异常");
       ctx.close();
   }
}
