/**
 * @program: LeetCodeJavaTest
 * @description: 666
 * @author: Mr.Sun
 * @create: 2021-07-07 22:59
 **/
/*
* 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
*
* */
public class JianZhi_64 {
    /*
    K神题解： 由于条件限制导致，直接套求和公式，递归，和 for循环都不能使用
    这里考虑  短路与  A && B 特点： 当 A为 false 时，B就不会判断了。这就可以很好的作为递归的终止条件了
    * */

    class Solution {
        int res = 0 ;
        public int sumNums(int n) {
            // 短路与的特性：   A  &&  B 当A为false时，则B将不会被判断
            boolean x = n>1 && sumNums(n-1)>0;
            res += n ;
            return res;
        }
    }

}
