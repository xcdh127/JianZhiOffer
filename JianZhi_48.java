import org.junit.Test;

import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第48题
 * @author: Mr.Sun
 * @create: 2021-07-19 22:31
 **/
/*
* 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * */
public class JianZhi_48 {

    /*
    * K神题解：定义f(i)为以第i个字符结尾的字符串的最大长度
    *          动态规划+双指针  左边指针指向-1，右边指针从0开始向后遍历字符串
    *          遍历字符串，将其字符作为key，索引记为value
    *          当遍历到相同字符时，更新i的索引，每次返回res和j-i较大者
    *
    * */

    public int getMaxChuan(String s){
//        左指针
        int i = -1;
//        当前最大长度
        int res = 0 ;
//        存放索引和字符的哈希表
        Map<Character,Integer> map = new HashMap<Character, Integer>();
//        右指针从0开始向后遍历
        for (int j =0 ;j<s.length();j++){
//            字符在前面出现过
            if (map.containsKey(s.charAt(j))){

//                更新i的索引
                i=Math.max(i,map.get(s.charAt(j)));
                res = Math.max(res,j-i);
            }

                map.put(s.charAt(j),j);
                res= Math.max(res,j-i);
        }
        return res ;

    }


    @Test
    public void test(){
        String s = "abcabcab";
        System.out.println(getMaxChuan(s));

    }


}
