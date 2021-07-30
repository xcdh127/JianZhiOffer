import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第43题
 * @author: Mr.Sun
 * @create: 2021-07-30 10:14
 **/
/*
* 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

 
* */
public class JianZhi_43 {
//    普通思路：挨个判断各个数位是否有1，统统统计在内
    public int countDigitOne(int n) {
        int num =0 ;
        for (int i = 1; i <= n; i++) {
            int temp = i ;
            while(temp!=0){
                if(temp%10==1){
                    num++;
                }
                temp/=10;
            }
        }
        return num ;
    }
    @Test
    public void test(){
        System.out.println(countDigitOne(12));
    }




    public int countDigitOnes(int n) {
//
//        通过观察，每个数位的数字值取0,1或者2~9对1~n中1的贡献是不同的
//        将数字分成 high ,cur ,low 和数位digit
//        当当前数位为 0时,1的个数完全取决于高位，high*digit
//        当当前数位为1时，1的个数取决于高位和低位，high*digit+low+1
//        当当前数位为2~9时，1的个数(high+1)*digit

//        初始化
        int res = 0;
        int digit = 1;
        int high=n/10;
        int cur=n%10;
        int low=0;

//        当当前数位不为0，或者高位不为0时执行
        while(high!=0 || cur!=0){
            if (cur==0){
                res+=high*digit;
            }else if (cur==1){
                res+=high*digit+low+1;
            }else {
                res+=(high+1)*digit;
            }
            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }
        return res ;
    }
    @Test
    public void testCountDigitOnes(){
        System.out.println(countDigitOnes(1111111));
    }

}
