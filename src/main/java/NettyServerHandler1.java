import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*小数据*/

public class NettyServerHandler1 extends ChannelInboundHandlerAdapter{

    private int byteRead=0;
    private volatile int startPos=0;
    private volatile int lastLength=0;
    public RandomAccessFile randomAccessFile;
    private File1 file1;
    byte[] bytes=null;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws IOException {
      // System.out.println(2);
        System.out.println(3);
        File file=new File(NettyServerHandler.ef.getPath());
        System.out.println(4);
        randomAccessFile=new RandomAccessFile(file,"r");
        System.out.println(5);
        randomAccessFile.seek(NettyServerHandler.ef.getStarPos());
        System.out.println(6);
        lastLength=(int)randomAccessFile.length();
         bytes=new byte[lastLength];

    }
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws IOException {
        Channel income=ctx.channel();
        if(msg instanceof File1) {
            file1 =(File1)msg;
            if ((byteRead = randomAccessFile.read(bytes)) != -1) {
                file1.setEndPos(byteRead);
              file1.setBytes(bytes);
                ctx.writeAndFlush(file1);


            }
            else
            {
                income.writeAndFlush("文件下载完成");
            }
        }







       Channel inComing=ctx.channel();
       // inComing.writeAndFlush("你好");
        //System.out.println(msg);
        System.out.println(1);
       // ctx.writeAndFlush("你好");

    }

}
