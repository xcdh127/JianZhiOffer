import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第16题
 * @author: Mr.Sun
 * @create: 2021-07-22 18:30
 **/
/*
* 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
提示：
-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
* */

public class JianZhi_16 {
/*
* K神题解：使用二分法，x的n次幂，等于 两个x的n/2次幂相乘 n/2向下取整，对n分奇数和偶数
*                    当n为奇数时，x *(x2)n/2 *(x2)n/2  ;
*                    当n为偶数时，(x2)n/2 *(x2)n/2    ;
*                    当n为负数时，将n取反，并将x取倒数，
*                    考虑到0不能取倒数，对其特殊考虑。当底数为0时，直接返回0
*                    因为位运算比乘除法的效率高很多，考虑用 &1操作 代替 求余数运算
*                    用右移 >> 运算代替 /2操作
*
* * * */
    double mypow(double x,int n){
//        特殊情况处理,底数为0时
        if (x==0){
            return 0;
        }
//        定义存放结果变量
        double res = 1.0;
//        当b为负的很大的数时会越界，所以换成长整型long
        long b= n;
//        当b为负数时
        if (b<0){
            x=1/x;
            b=-b;
        }
        while(b>0){
//            如果b为奇数，最后结果要多乘 x
            if ((b&1) == 1){
                res *= x ;
            }
//            x的平方
            x *= x;
//            /2 指导次数为0
            b >>= 1;

        }

        return res ;

    }
    @Test
    public void test(){
        System.out.println(mypow(3, 5));
    }






}




