import org.junit.Test;

import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第20题
 * @author: Mr.Sun
 * @create: 2021-07-28 21:17
 **/
/*
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：

若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分数值列举如下：

["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：

["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]

* */

public class JianZhi_20 {
        public boolean isNumber(String s) {
            Map[] states = {
                    // 0.前一个状态是空格，那么下一个可能的状态有：（1）空格
                    // （2）符号（3）数字 (4)没有数字的小数点
                    new HashMap<Character,Integer>(){{put(' ',0);put('s',1);put('d',2)
                    ;put('.',4);}},
                    // 1.前一个状态是e前的符号，下一个可能的状态有：（1）数字（2）不带数字的小数点
                    new HashMap<Character,Integer>(){{put('d',2);put('.',4);}},
                    // 2.前一个状态是e前的数字，下一个可能的状态是：（1）数字（2）有数字的小数点(3)e (4)空格
                    new HashMap<Character,Integer>(){{put('d',2);put('.',3);put('e',5)
                    ;put(' ',8);}},
                    // 3.前一个状态是有数字的小数点，下一个可能的状态有：（1）数字
                    //（2）e (3)数字最后的空格
                    new HashMap<Character,Integer>(){{put('d',3); put('e',5);put(' ',8);}},
                    // 4.前一个状态是没有数字的小数点，下一个可能的状态有：（1）数字
                    new HashMap<Character,Integer>(){{put('d',3);}},
                    // 5.前一个状态是e,下一个可能的状态有：（1）符号（2）数字
                    new HashMap<Character,Integer>(){{put('s',6);put('d',7);}},
                    // 6.前一个状态是e后的符号，下一个可能的状态有：（1）数字
                    new HashMap<Character,Integer>(){{put('d',7);}},
                    // 7.前一个状态是e后的数字，下一个可能的状态有：（1）数字
                    // （2）数字最后的空格
                    new HashMap<Character,Integer>(){{put('d',7);put(' ',8);}},
                    // 8.前一个状态是数字最后的空格，下一个可能的状态有：（1）空格
                    new HashMap<Character,Integer>(){{put(' ',8);}}
            };
            char t ;
            int p = 0 ;
            char[] ch = s.toCharArray();
            for (char c : ch) {
                if (c >='0' && c<='9') {
                    t = 'd';
                }
                else if(c=='+'||c=='-'){
                    t = 's' ;
                }
                else if(c=='.'||c==' '){
                    t = c ;
                }
                else if(c=='e'||c=='E'){
                    t = 'e';
                }
                else{
                    t = '?';
                }
                if(!states[p].containsKey(t)){
                    return false ;
                }
                p = (int)states[p].get(t);
            }
            return p==2 || p==3 || p==7 ||p==8 ;


        }

        @Test
        public void test(){
            System.out.println(isNumber("0e5"));

        }
        }




