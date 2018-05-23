import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    static Map<String,String>user=new ConcurrentHashMap<>();
    static Map<Channel,String>ip=new ConcurrentHashMap<>();
    static Map<String,String>uuser=new ConcurrentHashMap<>();
    public  User( )
    {
        user.put("User1","121");
        user.put("User2","122");
        user.put("User3","123");


    }

}
