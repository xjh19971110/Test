import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class NettyClient1 extends ChannelInboundHandlerAdapter {
    private int startPos=0;
    private  int endPos=0;
    private byte[] bytes;
    File1 ef=new File1();
    String fileName;
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws IOException {
        Channel inCome=ctx.channel();
       if(msg instanceof File1)
       {
           ef=(File1)msg;
           byte[] bytes=ef.getBytes();
           endPos=ef.getEndPos();
           String fileName=ef.getFileName();
           String path="D:/JAVA3/4.txt";
           File file=new File(path);
           RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
           randomAccessFile.seek(startPos);
           randomAccessFile.write(bytes);
           if(endPos>0)
           {
               System.out.println("文件："+fileName+"已接收"+(endPos-startPos));
               ef.setStarPos(endPos);
               bytes=null;
               inCome.writeAndFlush(ef);

           }
           else
           {
               System.out.println("文件："+fileName+"已经下载完成");
               randomAccessFile.close();
           }


       }

    }


}
