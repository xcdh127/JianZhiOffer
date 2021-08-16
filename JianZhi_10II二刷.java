/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-16 18:12
 **/
public class JianZhi_10II二刷 {

    class Solution {
        public int numWays(int n) {
            if(n==0 || n==1) return 1;
            int sum=0;
            int a=1;
            int b=1;
            for(int i=2;i<=n;i++){
                sum=(a+b)%1000000007;
                a=b;
                b=sum;
            }
            return sum;
        }
    }


}
