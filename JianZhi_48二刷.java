import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-22 15:13
 **/
public class JianZhi_48二刷 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map = new HashMap<Character,Integer>();
            char[] ch = s.toCharArray();
            int i=-1;
            int res = 0;
            for(int j=0;j<ch.length;j++){
                if(map.containsKey(ch[j])) i=Math.max(i,map.get(ch[j]));
                res=Math.max(res,j-i);
                map.put(ch[j],j);
            }
            return res ;
        }
    }
}
