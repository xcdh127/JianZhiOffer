/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-17 16:43
 **/
public class JianZhi_49二刷 {

    class Solution {
        public int nthUglyNumber(int n) {
            int a=0;
            int b=0;
            int c=0;
            int[] dp = new int[n+1];
            dp[0]=1;
            for(int i=1;i<=n;i++){
                dp[i]=Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
                if(dp[a]*2==dp[i]) a++;
                if(dp[b]*3==dp[i]) b++;
                if(dp[c]*5==dp[i]) c++;
            }
            return dp[n-1];
        }
    }

}
