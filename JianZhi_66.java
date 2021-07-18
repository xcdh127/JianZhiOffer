import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第66题
 * @author: Mr.Sun
 * @create: 2021-07-18 20:32
 **/
/*

给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
示例:
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
* */
public class JianZhi_66 {

    /*
    * K神题解：B[i]=A[0]*A[1]*...A[i-1]*A[i+1]*...*A[n-1]*A[n]将B[i]对应的 i的位置写成1,即
    *       A[0] A[1] A[2] A[3] A[4]
    * B[0]   1    2    3    4     5
    * B[1]   1    1    3    4     5
    * B[2]   1    2    1    4     5
    * B[3]   1    2    3    1     5
    * B[4]   1    2    3    4     1
    *
    * 先计算下三角的数字乘积，再计算上三角对应数字的乘积
    *
    * */

    public int[] mutilfy(int[] a){
        if (a==null||a.length==0)return new int[0];
        int len = a.length;
        int[] b = new int[len];
        b[0]=1;
        for (int i = 1; i < len; i++) {
            b[i]=b[i-1]*a[i-1];
        }
        int temp = 1 ;
        for (int i = len-2; i >=0 ; i--) {
            temp *= a[i+1];
            b[i]*=temp ;
        }
        return b ;


    }



    @Test
    public void test(){
        int[] a = {3,5,6,7};
        System.out.println(Arrays.toString(mutilfy(a)));//[210,126,105,90]


    }







}
