
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FileName {
   static public Map<String,String>novel=new ConcurrentHashMap<>();
   public  FileName()
   {
       novel.put("1.txt","D:/JAVA3/1.txt");
       novel.put("2.txt","D:/JAVA3/2.txt");
       novel.put("3.txt","D:/JAVA3/3.txt");
   }

}
