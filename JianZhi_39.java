import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第39题
 * @author: Mr.Sun
 * @create: 2021-07-01 18:57
 **/
/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
* */
public class JianZhi_39 {
    @Test
    public void test(){
        Integer integer = new Integer(1);
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int num = Solution014.majorityElement(nums);
        System.out.println(num);
    }


}
class Solution014 {
//    我的思路：遍历一遍数组，记录下，每一个数出现的次数。将次数大于一半的数字输出即可。
    public static int majorityElement(int[] nums) {
        int num = 0 ;
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<length;i++){
            if(map.get(nums[i])!=null){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(int i = 0;i<length;i++){
            if(map.get(nums[i])>length/2){
                num = nums[i];
            }
        }
        return num ;
    }

}



class Solution015 {
/*
   K神题解：
   使用摩尔投票法，思想：
   假定数组的第一个元素就是众数，票数记为 1，当下一个元素与当前数字大小不一致时，票数减 1
                                          当下一个元素与当前元素大小一致时， 票数加 1
                                      出现次数最多的数字的票数一定是大于 0 的，所以输出最后一次假定的众数即可。

*/
    public int majorityElement(int[] nums) {
        // 定义当前众数
        int num = nums[0];
        // 定义一个当前票数
        int sum = 1;
        for(int i = 1;i<nums.length;i++){
            if(num == nums[i]){
                sum++ ;
            }
            if(num != nums[i]){
                sum--;
            }
            if(sum == 0){
                num = nums[i+1];
            }
        }
        return num ;
    }
}
