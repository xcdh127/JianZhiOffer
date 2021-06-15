import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 第一个只出现1次的字符
 * @author: Mr.Sun
 * @create: 2021-06-13 13:41
 **/
public class JianZhi_50 {
    @Test
    public void test(){
    String str = "atatcccc";
        System.out.println(firstUniqChar(str));
    }

    public static char firstUniqChar(String s) {
        int length = s.length();
//        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int n = 0;
        for (int i = 0;i<length;i++){
            if (map.get(s.charAt(i))!=null){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        int i =0;
        while(i<length && map.get(s.charAt(i))!=1){
            i++;
        }
        if (i == length){
            return ' ';
        }
        return s.charAt(i);
    }
}
