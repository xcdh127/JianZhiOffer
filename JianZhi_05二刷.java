import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 05
 * @author: Mr.Sun
 * @create: 2021-07-31 13:37
 **/
/*
* 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class JianZhi_05二刷 {



        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            s.trim();
            char[] ch = s.toCharArray();
            for (char c : ch) {
                if(c==' '){
                    sb.append("%20");
                }else{
                    sb.append(c);
                }
            }
            return sb.toString();
        }





    @Test
    public void test(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("%20");
//        System.out.println(sb.toString());
        String s= "45 76 8";
        System.out.println(replaceSpace(s));
    }


}
