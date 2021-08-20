/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:55
 **/
public class JianZhi_56I二刷 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int x=0;
            int y=0;
            int res = 0;
            int m=1;
            for(int num : nums){
                res^=num;
            }
            while((res&m)==0){
                m<<=1;
            }
            for(int num : nums){
                if((m&num)!=0) x^=num;
                else y^=num;
            }
            return new int[]{x,y};
        }
    }


}
