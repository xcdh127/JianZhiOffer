import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指OFFER第57题 II
 * @author: Mr.Sun
 * @create: 2021-06-15 17:01
 **/
/*
* 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
* */

public class JianZhi_57II {
    @Test
    public void Test(){
//        初始化序列
//        举个例子，找和为15的连续序列
        int target = 15;
        int i =1 ;
        int j =2 ;
//      较小数字的边界条件
        int bound = target+1/2;
        int sum = 0;
        int[][] res = new int[1][bound];
        while(i<=bound){
            //        对序列求和
            for(int n = i;n<=j;n++){
                sum+=n;
            }
            System.out.println(sum);
//            对求和结果进行判断，如果和大于target，则将较小数字的序列移除一个，即i++
//                               如果和小于target，则将再包含一个较大的数字进入序列，即j++;
            if (sum<target) j++;
            if (sum>target) i++;
            int n = 0;
            if (sum == target){
                int[] arr = new  int[bound];
                for (int k = 0; k <j-i+1; k++) {
                    arr[k] = k ;
                }
                System.out.println(Arrays.toString(arr));
//                List res3 = new ArrayList<>();

                res[1] = arr;
            }


        }
//        return res ;
    }


     @Test
     public void test(){
      List<int[]> list = new ArrayList<>();
      list.add(new int[]{1,3});
      list.add(new int[] {2,5,6,9 });
      list.add(new int[3] );

    System.out.println(Arrays.toString(list.toArray()));


}


//此代码跑通
    class Solution {
        public int[][] findContinuousSequence(int target) {
            //      较小数字的边界条件
            int bound = target+1/2;
            int i =1 ;
            int j =2 ;
            List<int[]> res = new ArrayList<>();
            while(i<j){
                //        对序列求和
                int sum = 0;
                for(int n = i;n<=j;n++){
                    sum+=n;
                }
//            对求和结果进行判断，如果和大于target，则将较小数字的序列移除一个，即i++
//                              如果和小于target，则将再包含一个较大的数字进入序列，即j++;
                if (sum < target) j++;
                if (sum > target) i++;
                if (sum == target){
                    int[] arr = new  int[j-i+1];
                    int n=0;
                    for (int k = i; k <=j; k++) {
                        arr[n++] = k ;
                    }
                    res.add(arr);
                    i++;
                }
            }
            return res.toArray(new int[0][]) ;
        }
    }





//滑动窗口，双指针解法，注意窗口滑入与滑出的数字求和处理。
//    数字滑出，先减(-i)后加(i++)；数字滑入，先加（j++）后加(+j)
//K神代码：每一次都利用之前一次的求和结果，大大减少了计算量

    class Solution3 {
        public int[][] findContinuousSequence(int target) {
            //      较小数字的边界条件
            int bound = target+1/2;
            int i = 1 ;
            int j = 2 ;
            int s = 3 ;
            List<int[]> res = new ArrayList<>();
            while(i<j){
                if(s==target){
                    int[] arr = new int[j-i+1];
                    for(int k=i;k<=j;k++){
                        arr[k-i]=k;
                    }
                    res.add(arr);
                }
// 和小于target，多包含一个数进来，j++
                if(s<target){
                    j++;
                    s+=j;
                }
//  和大于或者等于target，少包含一个数，i++
                else if(s>=target){
                    s-=i;
                    i++;
                }
            }
            return res.toArray(new int[0][]);
        }
    }



}
