import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第44题
 * @author: Mr.Sun
 * @create: 2021-07-25 18:37
 **/
/*
* 数字以0123456789101112131415…的格式序列化到一个字符序列中。
* 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

* */
/*
* K神题解： 本题要找的数位有规律可循
*           1~9
*          首先 前9个数字 是一位数字，当n大于9时，一定不在这个范围；位数为 1 ，数位为9
*          10~99
*           接下来的90个数字是两位数，位数为2 ，数位为180
*           接下来的900个数字是三位数，位数为3，数位为2700
*
*           ...
*
* */
public class JianZhi_44 {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1 ;
        long count = 9 ;
        while(n > count){
            n -= count ;
            start*=10;
            digit+=1;
            count = 9*start*digit ;
        }
        long num = start + (n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }



    @Test
    public void test(){
        System.out.println(findNthDigit(6778));

    }
}
