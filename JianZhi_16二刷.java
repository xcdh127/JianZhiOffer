/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-14 08:32
 **/
public class JianZhi_16二刷 {

    class Solution {
        public double myPow(double x, int n) {
            if(x==0) return 0.0;
            long b=n;
            double res =1.0;
            if(n<0){
                b=-b;
                x=1/x;
            }
            while(b>0){
                if((b&1)==1)res=res*x;
                x=x*x;
                b>>=1;
            }
            return res ;
        }
    }
}
