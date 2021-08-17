/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-17 20:07
 **/
public class JianZhi_60二刷 {

    class Solution {
        public double[] dicesProbability(int n) {
            double[] res = {1/6.0,1/6.0,1/6.0,1/6.0,1/6.0,1/6.0};
            for(int i=2;i<=n;i++){
                double[] temp=new double[5*i+1];
                for(int k=0;k<5*(i-1)+1;k++){
                    for(int m=0;m<6;m++){
                        temp[m+k]+=res[k]/6.0;
                    }
                }
                res=temp;
            }
            return res ;
        }
    }
}
