import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 19:46
 **/
public class JianZhi_44二刷 {
    @Test
    public void test(){

    String s="34";
        System.out.println(s.charAt(1));
    }

    class Solution {
        public int findNthDigit(int n){
            int digit=1;
            long start=1;
            long count=9;
            while(n>count){
                n-=count;
                digit+=1;
                start*=10;
                count=digit*9*start;
            }
            long num=start+(n-1)/digit;
            return Long.toString(num).charAt((n-1)%digit)-'0';

        }
    }



}
