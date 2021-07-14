import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第42题
 * @author: Mr.Sun
 * @create: 2021-07-01 17:23
 **/
/*
* 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。
示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

* */
public class JianZhi_42 {

    public static void main(String[] args) {

        int[] arr = {2,5,4,-8,4,2,7,2};
        System.out.println(maxSubArray(arr));
        /*
        *   K神题解：思路一：观察数组相加的规律，当当前数组的和为负数时，那么它和下一位相加的和还没有下一位数字大呢，还不如将和置为下一位数字
        *   当相加过程中存在和大于当前最大和则更新最大和
        * */
}

    public static int maxSubArray(int[] nums) {
        int numSum=0;
        int maxSum=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (numSum<0){
                numSum=nums[i];
            }else {
                numSum+=nums[i];
            }
            if (numSum>maxSum){
                maxSum=numSum;
            }
        }
        return maxSum;
    }



//    思路二：动态规划解法：定义dp数组的含义：dp[i]表示以nums[i]结尾的连续数组的最大和
//               状态转移方程：dp[i-1]<0时，dp[i]=nums[i];dp[i-1]>0时，dp[i]=nums[i]+dp[i-1]

    public static int maxSubArrays(int[] nums){
//        dp[0]为初始值，表示以nums[0]结尾的连续数字的最大和
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=Math.max(0,nums[i-1]);
            res = Math.max(res,nums[i]);
        }
        return res ;
    }
    @Test
    public void test(){
        int[] nums = {2,5,3,-7,6,3};
        System.out.println(maxSubArrays(nums));
    }










}
