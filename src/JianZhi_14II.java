/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第14题第2小题
 * @author: Mr.Sun
 * @create: 2021-07-27 19:30
 **/
/*
* 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

* */

public class JianZhi_14II {

    /*
    * 与第一问的区别在于大数越界问题，每一次幂都进行求余操作
    * */


    public int cuttingRope(int n) {
        int m = n/3;
        long res = 1 ;
//        当数字可以整除3时，结果为3的m次幂
        if (n%3==0){
            for (int i =0;i<m;i++){
                res = res*3%1000000007;
            }
        }
        if (n%3==1){
            for (int i = 0; i <m-1 ; i++) {
                res = res*3%1000000007;
            }
            res = res*2*2%1000000007;
        }
        if (n%3==2){
            for (int i=0;i<m;i++){
                res = res*3%1000000007;
            }
            res  = res*2%1000000007;
        }
        return (int)res ;
    }


}
