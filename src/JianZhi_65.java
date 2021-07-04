import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第65题
 * @author: Mr.Sun
 * @create: 2021-07-04 21:01
 **/
/*
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
* */

public class JianZhi_65 {
    /*
    * 由于不让使用四则运算，所以考虑位运算。通过观察：
    *                            (1)第一步：将两数的二进制作不进位加法(这操作与 异或 等价)；
    *                            (2)第二步：计算进位(这个操作与 与运算并且左移一位 等价)；
    *                            (3)第三步：将第一步的结果与第二步的结果作与运算(这波操作还是 异或 等价)，并直到进位为 0 ；
    *
    *
    * */

    public static int add(int a,int b){
//        定义不进位之和
        int sum = 0;
//        定义进位
        int upBit = 0 ;

        do{
            sum = a^b ;
            upBit = (a&b)<<1;
            a = sum ;
            b = upBit ;
        }while(upBit!=0);

        return a ;
    }


    @Test
    public void test(){
        System.out.println(add(2, 5));


    }


}
