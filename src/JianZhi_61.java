import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第61题
 * @author: Mr.Sun
 * @create: 2021-07-06 21:05
 **/
/*
* 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
* 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
*
* */

public class JianZhi_61 {
/*
* 本题思路：应为大小王可以看看成任意的数字吗，所以我们要做的事情是
*            （1）首先将数组排序
*            （2）统计数字中 0 的个数
*            （3）计算相邻位置上数字之间的差值
*            （4）判断 0 的个数是否大于数字之间的差值，也就是 0 是否可以作为任意数字来补全这个不连续的数字
*
* */
    public boolean isStraight(int[] nums){
        int zeroNum = 0;
        int difNum = 0 ;
        boolean flag = false ;
//        第一步：先将数组排序
        Arrays.sort(nums);
//        第二步：统计数组中 0 的个数
        for(int i =0;i<nums.length;i++){
            if (nums[i]==0){
                zeroNum++ ;
            }
        }
//        第三步：统计相邻数字间的差值之和，也就是统计不相邻数字之间空缺的位置的2数量
        for(int i = zeroNum+1;i<nums.length;i++){
//            从数字 0 位置 向后统计两数字之间的差值
            if(nums[i]-nums[i-1]>1){
                difNum+=nums[i]-nums[i-1];
            }
//            如果 0 向后的位置有数字的差值为 0 ，即出现对子，不可能连续，直接返回 false
            if(nums[i] == nums[i-1]){
                return flag ;
            }
        }
//        如果数组中 0 的个数大于空缺的数字的个数，返回true
        if (zeroNum >=difNum){
            flag = true ;
        }
        return flag ;
    }
    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        System.out.println(isStraight(nums));

    }

    /*
    * K神题解：思路：通过观察，（1）没有大小王（2）有一个大小王（3）有两个大小王 如果满足连续数组，必须遵守如下规则
    *                          1.数组中除 0 外，没有重复的数字
    *                          2.数组中最大的数字 - 最小的数字 小于 5
    *           因此我们可以这样：（1）遍历数组一遍，记录最大值和最小值
    *                            （2）遇到 0 跳过，走下一步
    *                           （3）用集合 set存放数字，如果重复直接返回 false
    *       set + 遍历方法
    * */
    public boolean isLianXv(int[] nums){
        Set<Integer> set  = new HashSet<>();
        int max = 0 ;
        int min = 14 ;
        for(int i =0;i<nums.length;i++){
//            遇到 0 直接跳过，进入下一次循环
            if(nums[i]==0) continue;
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
            if (set.contains(nums[i])) return false ;
            set.add(nums[i]);
        }
        return max - min <5 ;
    }

    @Test
    public void test01(){
        int[] nums = {0,0,2,4,7} ;
        System.out.println(isLianXv(nums));
    }



    /*
    * 排序 + 遍历方法
    *
    * */

    public boolean isLianXu(int[] nums){
        int zeroNum = 0 ;
//        (1)先对数组排序
        Arrays.sort(nums);
//        (2)统计数组中 0 的个数
        for(int i = 0;i<4;i++){
            if (nums[i]==0){
                zeroNum++;
                continue;
            }
            if (nums[i+1]==nums[i]) return false ;
        }
        return nums[4]-nums[zeroNum]<5;
    }

    @Test
    public void test02(){
        int[] nums = {0,0,1,4,6} ;
        System.out.println(isLianXu(nums));
    }
}
