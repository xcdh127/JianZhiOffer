import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:53
 **/
public class JianZhi_20二刷 {

    class Solution {
        public boolean isNumber(String s){
            Map[] status = {
//0前一位是e前的空格，下一位可以的状态
                    new HashMap<Character,Integer>(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
//1前一位是e前的符号，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('d',2);put('.',4);}},
//2前一位是e前小数点前的数字，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
//3前一位是e前小数点，及小数点后的数字，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('d',3);put('e',5);put(' ',8);}},
//4前一位是e前没有数字的小数点，及小数点后的数字，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('d',3);}},
//5前一位是e，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('s',6);put('d',7);}},
//6前一位是e后的符号，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('d',7);}},
//7前一位是e后的数字，下一位可以的状态
                    new HashMap<Character,Integer>(){{put('d',7);put(' ',8);}},
//8前一位是e后的空格，下一位可以的状态
                    new HashMap<Character,Integer>(){{put(' ',8);}}
            };
            int res = 0;
            char t=' ';
            char[] ch= s.toCharArray();
            for(char c : ch){
                if(c>='0' && c<='9') t='d';
                else if(c=='+' || c=='-') t='s';
                else if(c=='e' || c=='E') t='e';
                else if(c=='.' || c==' ') t=c;
                else  t='?' ;
                if(!status[res].containsKey(t)) return false ;
                res=(int)status[res].get(t);
            }
            return res==2 || res==3 || res==7 || res==8 ;
        }
    }



}
