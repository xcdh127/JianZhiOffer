import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description: 666
 * @author: Mr.Sun
 * @create: 2021-07-17 22:12
 **/
/*
*
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
* */

public class JianZhi_60 {
    /*
    * K神题解：动态规划题目：定义f(n,x)为n个筛子和为x的概率
    *             f(n-1,x)只与f(n,x+1),f(n,x+2),f(n,x+3),f(n,x+4),f(n,x+5),f(n,x+6)有关系
    * */

    public double[] value(int n){
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for (int i=2;i<=n;i++){
            double[] temp = new double[5*i+1];
            for (int k =0;k<dp.length;k++){
                for (int j =0;j<6;j++){
                    temp[j+k]+=dp[j]/6.0;
                }
            }
            dp=temp;
        }

        return dp ;

    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(value(2)));
    }

}
