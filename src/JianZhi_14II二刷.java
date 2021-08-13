/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-13 13:29
 **/
public class JianZhi_14II二刷 {
    class Solution {
        public int cuttingRope(int n) {
            if(n<=3) return n-1;
            int m=n/3-1;
            int r=n%3;
            long res=1;
            long x=3;
            while(m>0){
                if(m%2==1) res=res*x%1000000007;
                x=x*x%1000000007;
                m/=2;
            }
            if(r==0) return (int)(res*3%1000000007);
            if(r==1) return (int)(res*4%1000000007);
            return (int)(res*6%1000000007);
        }
    }



}
