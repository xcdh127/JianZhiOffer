/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:57
 **/
public class JianZhi_39二刷 {

    class Solution {
        public int majorityElement(int[] nums) {
            int val=0;
            int vote=0;
            for(int num : nums){
                if(vote==0) val=num;
                vote+= num==val?1:-1;
            }
            return val ;
        }
    }
}
