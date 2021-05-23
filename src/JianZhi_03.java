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



    public void Answer(){
/*
* 参考答案思路：
* n个元素，范围是0~n-1,如果范围是0~n且没有
*
*
*
* */



    }
}
