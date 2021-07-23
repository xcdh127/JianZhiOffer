import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第46题
 * @author: Mr.Sun
 * @create: 2021-07-23 19:36
 **/
/*
* 给定一个数字，我们按照如下规则把它翻译为字符串：
* 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
* 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。


示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 
* */
public class JianZhi_46 {
    /*
    * K神题解：动态规划思路：x1x2x3x4...xi-2有dp[i-2]种分解方法；
    *                      x1x2x3x4...xi-1有dp[i-1]种分解方法；
    *
    *                      x1x2x3x4...xi-2  xi-1xi 当xi-1xi可以分解时，[10,25]
    *                      x1x2x3x4...xi-2xi-1  x  当xi-1xi不可以分解时，[0,10)和(25,99]
    *                 初始值dp[0] = 1;dp[1] = 1;
    *
    * */


    int fanyi(int num){
//        因为dp[i]只与dp[i-1]有关，可以简化dp[i]数组

        int a = 1;
        int b = 1;
//        求这个数字的个位数字
        int y = num % 10 ;

        while(num != 0){
            num /= 10 ;
//            求十位数字
            int x = num % 10;
//            判断当前两位组成的数字是否在[10，25]间
            int c = ((10*x +y)>=10 && (10 * x+y)<=25)?a+b:a;
            b=a;
            a=c;
            y=x;
        }
        return  a ;

    }

    @Test
    public void test(){
        System.out.println(fanyi(
                21331));

    }










}
