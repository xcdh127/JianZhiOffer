import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第49题
 * @author: Mr.Sun
 * @create: 2021-07-16 22:22
 **/
public class JianZhi_49 {

    public int nthUglyNumber(int n) {
     int num = 1;
     int i = 2;
     while (num<=n){
         if (isAgNum(i)){
             num++;
         }
         i++;
     }
       return i;
    }





    public boolean isAgNum(int n){
        while (n!=1){
            if (n%2==0)n/=2;
            else if (n%3==0)n/=3;
            else if (n%5==0)n/=5;
            else return false;
        }
        return true ;
    }

    @Test
    public void test(){
//        System.out.println(isAgNum(14));

        System.out.println(nthUglyNumber(10));

    }



    /*
    * K神题解：动态规划
    * */

    class Solution {
        public int nthUglyNumber(int n) {
            int a= 0;
            int b= 0;
            int c= 0;
            int[] dp = new int[n] ;
            dp[0]=1;
            for(int i =1;i<n;i++){
                int n2=dp[a]*2;
                int n3=dp[b]*3;
                int n5=dp[c]*5;
                dp[i]=Math.min(Math.min(n2,n3),n5);
                if(dp[i]==n2)a++;
                if(dp[i]==n3)b++;
                if(dp[i]==n5)c++;
            }
            return dp[n-1];

        }

    }

}
