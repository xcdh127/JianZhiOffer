/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-21 13:27
 **/
public class JianZhi_65二刷 {
    class Solution {
        public int add(int a, int b) {
            while(b!=0){
                int c=a;
                a=a^b;
                b=(c&b)<<1;
            }
            return a ;
        }
    }


}
