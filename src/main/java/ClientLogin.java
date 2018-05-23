import io.netty.channel.Channel;

import java.util.Scanner;

public class ClientLogin {
    static boolean flag=false;
    public void Login(Channel channel)
    {

        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String User_Name=input.nextLine();
        System.out.println("请输入密码：");
        String passWord=input.nextLine();
        channel.writeAndFlush(User_Name+" "+passWord);

    }
}
