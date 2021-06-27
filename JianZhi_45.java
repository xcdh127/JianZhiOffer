/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第45题
 * @author: Mr.Sun
 * @create: 2021-06-27 18:59
 **/
/*
*
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"
 */
public class JianZhi_45 {
//    K神题解：
    /*
    * 思路：本质上还是排序问题，排序规则特殊定义，(x+y)>=(y+x)则 x 排在 y 的右边
    *                                         (x+y)<=(y+x)则 x 排在 X 的左边
    *       使用快速排序算法，修改排序规则。
    * */

    class Solution {
        public String minNumber(int[] nums) {
            String[] str = new String[nums.length];
            for(int i = 0;i<nums.length;i++){
                str[i] = String.valueOf(nums[i]);
            }
            quickSort(str,0,nums.length-1);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<nums.length;i++){
                sb.append(str[i]);
            }
            return sb.toString();
        }

        public void quickSort(String[] nums,int l,int r){
            if(l >= r) return;
            int i = l;
            int j = r;
            String temp = nums[i];
            while(i < j){
                /*
                * (x+y)>=(y+x)则 x 排在 y 的右边
                  (x+y)<=(y+x)则 x 排在 X 的左边
                  记住顺序：
                          先j--,后i++
                  */
                while(i < j && (nums[l]+nums[j]).compareTo(nums[j]+nums[l]) <= 0 ) j--;
                while(i < j && (nums[l]+nums[i]).compareTo(nums[i]+nums[l]) >= 0 ) i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp ;
            }
//            把基准值赋值给nums[i=j]
            nums[i] = nums[l];
//            把nums[i=j]赋值给原基准值
            nums[l] = temp;
//            对新基准值左侧快排
            quickSort(nums,l,i-1);
//            对新基准值右侧快排
            quickSort(nums,i+1,r);
        }

    }


}
