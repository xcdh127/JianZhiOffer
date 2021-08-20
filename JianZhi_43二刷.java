/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:58
 **/
public class JianZhi_43二刷 {
    class Solution {
        public int countDigitOne(int n) {
            int low=0;
            int cur=n%10;
            int high=n/10;
            int digit=1;
            int res = 0;
            while(high!=0 || cur!=0){
                if(cur==0)res+=high	* digit;
                else if(cur==1) res+=high*digit+low+1;
                else res+=(high+1)*digit;
                low+=cur*digit;
                cur=high%10;
                high/=10;
                digit*=10;
            }
            return res ;
        }
    }

}
