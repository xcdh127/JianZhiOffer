/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-16 18:11
 **/
public class JianZhi_42二刷 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int res=nums[0];
            for(int i=1;i<=nums.length-1;i++){
                nums[i]=nums[i]+Math.max(nums[i-1],0);
                res=Math.max(res,nums[i]);
            }
            return res ;
        }
    }

}
