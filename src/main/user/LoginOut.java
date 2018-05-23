import io.netty.channel.Channel;

public class LoginOut {

   static  public String Cancellation(String User_Name,Channel channel)
    {
        String sendMsg;
        String passWord;
        passWord=User.uuser.get(User_Name);
        User.user.put(User_Name,passWord);
        User.uuser.remove(User_Name,passWord);
        User.ip.remove(channel);
        sendMsg="成功退出";
        return sendMsg;

    }

}
