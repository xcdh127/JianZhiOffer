/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-13 13:28
 **/
public class JianZhi_14I二刷 {
    class Solution {
        public int cuttingRope(int n) {
            if(n<=3)return n-1;
            int m=n/3;
            int r=n%3;
            if(r==0)return (int)Math.pow(3,m);
            if(r==1)return (int)Math.pow(3,m-1)*4;
            return (int)Math.pow(3,m)*2;
        }
    }
}
