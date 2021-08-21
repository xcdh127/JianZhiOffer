/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-21 13:28
 **/
public class JianZhi_64二刷 {
    class Solution {
        int res=0;
        public int sumNums(int n) {
            boolean x = n>1 && sumNums(n-1)>0;
            res+=n;
            return res ;
        }
    }


}
