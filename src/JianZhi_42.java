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

    @Test
    public void test(){
    int[] nums = {2,4,1,3};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));



}



}
