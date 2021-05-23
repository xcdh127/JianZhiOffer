import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer03题
 * @author: Mr.Sun
 * @create: 2021-05-23 18:23
 **/
public class JianZhi_03 {
    /*
    * 找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
请找出数组中任意一个重复的数字。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    public static int findRepeatNumber(int[] a){

        /*
        * 2021.5.23
        * 我的思路：
        * 1、先使用冒泡排序算法把数组进行从小到大排序
        * 2、从将最小的数字和其后面的数字依次比较
        * */

//        使用冒泡排序算法，对数组进行从小到大排序
        int temp;
        int n=0;
        for (int i = 0; i < a.length; i++) {
            for(int j =i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    n++;
                }
            }
        }
//        System.out.println(Arrays.toString(a));


//      对排过顺序的数组，查找第一个重复的数字
        int i = 0;
        while(a[i]!=a[i+1]){
            i++;
        }
        return a[i];
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,7};
        System.out.println(findRepeatNumber(num));
    }


    @Test
    public void test(){
//手写冒泡排序算法
//        出现的一个问题是j变量的最大值和i的最大值是一样，都是小于数组的长度。
        int[] a = {2,1,3,6,5};
//        System.out.println(a.toString());
        int temp;
        int n=0;
        for (int i = 0; i < a.length; i++) {
            for(int j =i+1;j<a.length;j++){
                if (a[i]>a[j]){
                 temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
                 n++;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }



    public int Answer(int[] nums){
/*
* 参考答案思路：
* n个元素，范围是0~n-1,如果范围是0~n且没有重复数字（从小到大排序），则数组的下标和所存储的元素大小相同。
* 算法过程：从i=0开始，a[0]=m,m不等于0;若a[m]=0，则将a[m]和a[0]交换位置，将0放到下标是0的位置。a[m]不等于0等于K，
* 交换后继续将m与a[k]交换位置，直到a[i]和a[m]相等为止。
*
*看答案后启示：
* 要让数组下标和在这个位置上的元素大小相等，直到出现重复的数字结束。
*
* 通过LeetCode
*
* */
        int m=0;
        int temp;


        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i) {
                m = nums[i];
                if (m == i) {
                    continue;
                } else if (m == nums[m]) {
                    break;
                } else {
                    temp = m;
                    nums[i] = nums[m];
                    nums[m] = temp;
                }
            }

        }
        return m;
    }


    public int AnswerBetter(int[] nums){
        /*
         * 参考答案思路：
         * n个元素，范围是0~n-1,如果范围是0~n且没有重复数字（从小到大排序），则数组的下标和所存储的元素大小相同。
         * 算法过程：从i=0开始，a[0]=m,m不等于0;若a[m]=0，则将a[m]和a[0]交换位置，将0放到下标是0的位置。a[m]不等于0等于K，
         * 交换后继续将m与a[k]交换位置，直到a[i]和a[m]相等为止。
         *
         *看答案后启示：
         * 要让数组下标和在这个位置上的元素大小相等，直到出现重复的数字结束。
         *
         * 通过LeetCode,一个萝卜一个坑。
         *
         * */
        int temp;


        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i) {
            if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
               temp = nums[i];
                nums[i]= nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    @Test
    public void Test(){

        int[] a = {2,3,1,0,2,5,3};
        System.out.println(AnswerBetter(a));
    }
}
