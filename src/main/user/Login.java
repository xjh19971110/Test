import io.netty.channel.Channel;

public class Login {
  static  User user1=new User();
   static  public String Verification(String User_Name,String passWord,Channel channel)
    {
        String sendMsg;
        if(user1.user.get(User_Name)==null)
        {
            sendMsg="用户名不存在";
            return sendMsg;

        }
        if(!user1.user.get(User_Name).equals(passWord))
        {
            sendMsg="密码错误";
            return sendMsg;
        }
        else
        {
            user1.user.remove(User_Name);
            user1.uuser.put(User_Name,passWord);
            user1.ip.put(channel,User_Name);
            sendMsg="欢迎登陆";
            return sendMsg;


        }


    }




}
