/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:57
 **/
public class JianZhi_62二刷 {

    class Solution {
        public int lastRemaining(int n, int m) {
            int x=0;
            for(int i=2;i<=n;i++)
                x=(x+m)%i;
            return x ;

        }
    }

}
