/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-16 18:11
 **/
public class JianZhi_10I二刷 {

    class Solution {
        public int fib(int n) {
            if(n==0 || n==1) return n;
            int a=0;
            int b=1;
            int sum=0;
            for(int i=2;i<=n;i++){
                sum=(a+b)%1000000007;
                a=b;
                b=sum;
            }
            return sum ;
        }
    }


}
