import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第56题第二小题
 * @author: Mr.Sun
 * @create: 2021-07-05 19:56
 **/

/*
* 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
*
* */
public class JianZhi_56II {
    /*
    * K神题解：    本题思路，m个相同的数字，他们的各位的和也是m的倍数，如果有一个数字不是m个，
    *              通过对求和后的位求余数就可以找到那个唯一的数字。
    * */

    public static int sigleNumber(int[] nums){
//        存放当前数字各位的值
        int[] counts = new int[32];
//        通过无符号右移运算，取到当前数字的各位的值,通过与 1相与获取每一位的值
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < counts.length; j++) {
//                统计数组中各位的值的和
                counts[j] += nums[i]&1;
                nums[i]>>>=1;
            }
        }
//        和模3，取余数
        for (int i = 0; i < counts.length; i++) {
            counts[i]%=3;
        }
        int res = 0 ;
//        循环左移，恢复出结果res
        for (int i = 0; i <counts.length; i++) {
            res<<=1;
            res|=counts[31-i];
        }
        return res ;
    }


    @Test
    public void test(){
        int[] nums = {2,2,2,5,4,4,4};
        System.out.println(sigleNumber(nums));

    }





}




