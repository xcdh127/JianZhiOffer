import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第二题目
 * @author: Mr.Sun
 * @create: 2021-05-25 18:04
 **/
public class JianZhi_02第二题 {

//题目：不修改数组，找出重复的数字。在一个长度为 n+1 的数组中，所有的数字都在1~n的范围内，所以数组中至少
//    有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
    public static int findDupilicateInArray(int[] arr){
//思路：由于不能修改输入的数组，因此想到创建一个新的数组。空间复杂度为O(n)。
//        将输入数组中的数字，放到新创建数字的对应下表位置上，当放入数字之前，新建数组位置上已经有数字了，则找到了重复的数字。
        int[] array = new int[arr.length];
        int i;
        for (i = 0; i < arr.length; i++) {
           if(array[arr[i]]!=0){
              break;
           }
            array[arr[i]]= arr[i];

        }

         return  array[arr[i]];
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        System.out.println(findDupilicateInArray(arr));
    }





//    这里考虑用时间来换取空间的方法。主要思想是二分查找。
    public static int findDupilicatedInArray(int[] arr){

     if(ArrayIsFine(arr)){
         int start = 1;
         int end = arr.length-1;
//         当 end=start 时，就找到了一个重复的数字
         while(end!=start){
             int mid = (start + end)>>1;
             int count = 0;
             for (int i = 0; i < arr.length; i++) {
                 if (arr[i]>=start && arr[i]<=mid){
                     count++;
                 }
             }

             if (count>(mid-start+1)){
                 end = mid;
             }else{
                 start = mid+1;
             }

         }

         return start;
     }

       return -1;
    }

    public static boolean ArrayIsFine(int[] arr){
        if (arr==null||arr.length==0){
            return false;
        }else{
            return true;
        }
    }
@Test
    public void test(){
        int[] arr = {1,2,3,4,5,5};
    System.out.println(findDupilicatedInArray(arr));
}
}


