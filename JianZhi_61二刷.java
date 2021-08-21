import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-21 13:29
 **/
public class JianZhi_61二刷 {

    class Solution {
        public boolean isStraight(int[] nums) {
            int diff=0;
            int zeroNum=0;
            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==0) zeroNum++;
                else if(nums[i]==nums[i+1]) return false;
                else diff+=nums[i+1]-nums[i]-1;
            }
            if(zeroNum>=diff) return true ;
            return false ;
        }
    }

}
