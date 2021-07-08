import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第10题
 * @author: Mr.Sun
 * @create: 2021-07-08 22:28
 **/
/*
* 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

* */
public class JianZhi_10 {
    /*
    * 剑指offer题解：   使用循环代替递归，将前面两个数字的和存起来下次使用，解决递归中重复计算的耗时
    * */

    int fib(int n){
//        当 n为 0或者1时，直接返回对应值
        int[] nums = {0,1};
        if (n<2)return nums[n];
//        求和的第一个数字
        int numOne = 1;
//        求和的第二个数字
        int numTwo = 0;
//        暂存的两数之和
        int sumTemp = 0;
        for (int i = 2; i <=n; i++) {
            sumTemp = (numOne+numTwo)%1000000007;
            numTwo = numOne;
            numOne = sumTemp;
        }
        return sumTemp;
    }
    @Test
    public void test(){
        System.out.println(fib(999));
    }



}

