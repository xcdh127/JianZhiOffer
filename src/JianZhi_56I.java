import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第56题第1小题
 * @author: Mr.Sun
 * @create: 2021-07-05 18:21
 **/
/*
* 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
* 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
* */

public class JianZhi_56I {

    /*
    * K神题解：
    * 考察位运算：   异或运算的性质：      当两个数字相等时，它们的异或结果是0
    * 当数组中的元素除了一个数字出现一次  而其余数字 都出现了两次，那么它们的异或结果就是那个只出现了一次的数字
    *
    * 本题而言：有两个出现一次的数字，因此不能直接异或出答案，但是通过异或可以得到 x 异或 y的值。
    * 因为 x 和  y值不同，至少有一位的值为 1，找到那个1的位置，并且根据这个位置将数组拆分成两部分，一部分包含x
    * 另一部分包含 y ,这样就可以直接异或操作找出两个只出现一次的数字了。
    *
    * */
    public static int[] singleNumber(int nums[]){
//        两个只出现了一次的数字 x，y
        int x=0,y=0;
//        z=x 异或 y
        int z= nums[0] ;
        for (int i=1;i<nums.length;i++){
           z^=nums[i];
        }
//         找出z中第一个不是0的数字，并且将这个位置作为拆分数组的依据
//        与 1相与 找到这个位置
        while((z&1)!=0){
            z<<=1;
        }
//        将数组中的数字的这一位为0，还是为1，拆分成两部分，分别异或出结果。
        for (int i = 0; i < nums.length; i++) {
            if ((z&nums[i])==0){x^=nums[i];
            }else{
                y^=nums[i];
            }
        }
        int res[] ={x,y};
        return res ;
    }


      @Test
      public void test(){
        int[] nums={2,2,5,5,6,1};
          System.out.println(Arrays.toString(singleNumber(nums)));


      }


}
