/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:56
 **/
public class JianZhi_15二刷 {

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while(n!=0){
                n=n&(n-1);
                res++;
            }
            return res ;
        }
    }


}
