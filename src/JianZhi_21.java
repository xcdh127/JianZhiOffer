/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第21题·
 * @author: Mr.Sun
 * @create: 2021-06-29 15:44
 **/
/*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。

* */
public class JianZhi_21 {
//    思路：双指针，排序；
//    定义；两个指针分别指向数组的第一个元素和最后一个元素，
//    第一个元素只向右寻找偶数，找到后停止
//    第二个元素只向左寻找级数，找到后停止
//    交换这两个数
//    继续上面的步骤
//    直到 i 和 j相遇为止
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<j && nums[i]%2!=0)i++;
            while(i<j && nums[j]%2==0)j--;
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }
}

}
