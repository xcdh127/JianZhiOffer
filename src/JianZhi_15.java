import org.junit.Test;

import javax.sound.midi.SoundbankResource;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第15题
 * @author: Mr.Sun
 * @create: 2021-07-03 22:09
 **/
/*
* 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
* */

public class JianZhi_15 {
/*
*  K神题解：
*  二进制位运算：     (1) n&1 = 1 说明该数的最右边一位是 1
*                    (2) n&1 = 0 说明该数的最右边一位是 0
*                    在java中，数字右移运算 为 " >>>= "
*                    逐位位运算
* */
    public static int solution(int num){
        int res = 0;
        while (num>0){
        res+=num&1;
        num >>>= 1 ;
        }
        return res ;
    }
    @Test
    public void test(){
        int num = 5;
        System.out.println(solution(5));
    }

}
