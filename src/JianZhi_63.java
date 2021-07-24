import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第63题
 * @author: Mr.Sun
 * @create: 2021-07-24 19:04
 **/
/*
*
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*
* */

public class JianZhi_63 {

    /*
    * 剑指offer题解思路：将第i个数字之前的最小的数字记录下来，当前数字减去之前数字的最小值可以得到可能的最大值
    *                  判断当前最大值是不是比之前的最大值还要大，遍历一遍数组即可。
    * */
    int findMax(int[] arr){

//        特殊判断
        if (arr == null || arr.length == 0){
            return 0 ;
        }

//        定义最大值
        int max = 0;
//        设数组的第一个数字为当前的最小值
        int  min = arr[0];
//        遍历数组，记录 前i-1个数组中的最小值
        for (int i = 1;i<arr.length;i++){
//            获取最小值
            if (arr[i-1] < min){
                min = arr[i-1];
            }
//            判断最大利润
            max = (arr[i]-min > max)? arr[i]-min :max ;
        }

        return max ;

    }

    @Test
    public void test(){
        int[] arr = {2,5,6,1,6,9};
        int[] arr1 = {} ;
        System.out.println(findMax(arr1));


    }













}
