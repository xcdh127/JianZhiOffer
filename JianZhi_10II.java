import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第2小题
 * @author: Mr.Sun
 * @create: 2021-07-09 22:21
 **/
/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1
*
* */
public class JianZhi_10II {
    /*
    * K神题解： 动态规划题目   ：  找到当前项与其他项的递推关系式，即 状态转移函数，对于本题，青蛙最后一步可以从最后一级跳上来，也可以从倒数第二级
    * 跳上来，也就是f(n) = f(n-1)+f(n-2)种方法，因此通过这个递推公式就可以就算了，但是缺少初始值，因此考虑初始值的情况，即
    * 当跳 0 级台阶时方法是 1 种，当跳1级台阶时方法是 1 种。即初始值 f(0) = 0;f(1 )= 1 ,建立dp数组，定义dp(i) 跳到第i级台阶有几种方法
    * */
   public int  numWays(int n){
//       定义dp数组
       int[] dp = new int[n+1];
       if(n==0||n==1){
           return 1;
       }
//       确定初始值
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<=n;i++){
           dp[i] = dp[i-1]+dp[i-2];
       }
       return dp[n];
   }
   @Test
   public void test(){
       System.out.println(numWays(5));
   }
}
