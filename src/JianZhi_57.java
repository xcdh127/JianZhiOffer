import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第57题
 * @author: Mr.Sun
 * @create: 2021-06-15 15:41
 **/
public class JianZhi_57 {

    @Test
    public void test(){
        int[][]  res1 = new int[5][5];
        res1[1][1] =1;
        System.out.println(Arrays.toString(res1));
    }
}


class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int[] res = new int[2] ;
        int sum = 0;
        while(i<j){
            sum= nums[i]+nums[j];
            if(sum<target) i++;
            if(sum>target) j--;
            if(sum == target){
                res[0]=nums[i];
                res[1]=nums[j];
                break;
            }
        }
        return res;


    }


}
