import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第57题
 * @author: Mr.Sun
 * @create: 2021-06-09 13:13
 **/
/*
* 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。
*
* */


public class JianZhi_67 {
    public static void main(String[] args) {
      /*  String str = "1024";
        char c = str.charAt(1);
        System.out.println(c);
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        String string = sb.toString();
        int i = Integer.parseInt(string);
        System.out.println(i);*/

      Test("   - 33 43 434");
    }


        public static int strToInt(String str) {
            str = str.trim();
          //  System.out.println(str);
            Integer res = 0;
            int num =Integer.valueOf(str.charAt(0));
            StringBuilder sb = new StringBuilder();
         //   System.out.println(str.charAt(0));
            //有符号的数字
            if(str.charAt(0)=='+' || str.charAt(0)=='-'){
                sb.append(str.charAt(0));
                int i = 1;
                while(i<str.length() && Integer.valueOf(str.charAt(i))>=47 && Integer.valueOf(str.charAt(i))<=58){
                    sb.append(str.charAt(i++));//将当前的数字加到sb中
                }
                res = Integer.parseInt(sb.toString());//将当前的数字加到sb中
            }
//获取第一个字符的ASCII码判断是不是数字，数字的Ascii码在47~58
            if(Integer.valueOf(str.charAt(0))<47 || Integer.valueOf(str.charAt(0))>58){
                return res;
            }
            //没有符号的数字

            if(Integer.valueOf(str.charAt(0))>=47 && Integer.valueOf(str.charAt(0))<=58){
                int i = 0;
                while( i<str.length() && Integer.valueOf(str.charAt(i))>=47 && Integer.valueOf(str.charAt(i))<=58){
                    sb.append(str.charAt(i));//将当前的数字加到sb中
                    i++;
                }
                res = Integer.parseInt(sb.toString());//将字符串转换成数字
            }

            if(res > 2147483647){
                return 2147483647;
            }else if(res < -2147483648){
                return -2147483648 ;
            }

            return res ;
        }

        public static int Test(String str){
//存储空间只有32位，整数范围在Integer.MAX_VALUE（2147483647）
//            考虑边界，有两种情况：
//            边界  boundary = Integer.MAX / 10 ;
//            1.res*10 >= 2147483650;
//            2.res*10 = 2147483640 并且char[i]>7;

            str = str.trim();
        //    System.out.println(str);
            char[] chars = str.trim().toCharArray();
            int res = 0;
            int sign = 1;
            int boundary = Integer.MAX_VALUE / 10 ;
            int i = 0 ;
//数字的ascii码转换成数字的方法是：用当前字符数字-0的ASCII码即可
            if (chars[i]=='-') sign = -1;
            if(chars[i]=='+' || chars[i]=='-') i++;
            for (int j = i; j < str.length(); j++) {
//                判断第一个字符是否是非数字字符
                if(chars[j]>'9' ||chars[j]<'0' ) break;
//           判断当前结果是否会超过边界值
                    if (res > boundary || (res == boundary && chars[j] > '7')){
                      return  sign == 1 ? Integer.MAX_VALUE :Integer.MIN_VALUE ;
                    }
                    res = res*10 + chars[j]-'0';
                }
            res = res*sign ;
            System.out.println(res);
            return res;
            }
















            //   System.out.println(strToInt(" 003  rerer"));

        }










