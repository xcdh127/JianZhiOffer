/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:59
 **/
public class JianZhi_66二刷 {
    class Solution {
        public int[] constructArr(int[] a) {
            if(a==null || a.length==0) return new int[0];
            int n =a.length;
            int[] dp = new int[n];
            int temp =1;
            dp[0]=1;
            for(int i=1;i<n;i++) dp[i]=a[i-1]*dp[i-1];
            for(int i=n-2;i>=0;i--){
                temp*=a[i+1];
                dp[i]*=temp;
            }
            return dp ;
        }
    }


}
