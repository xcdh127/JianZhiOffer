import org.junit.Test;

import java.util.Arrays;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-20 08:17
 **/
public class JIanZhi_17二刷 {
    int n ;
    int[] res = new int[(int)Math.pow(10,n)-1];
    char[] loop={'0','1','2','3','4','5','6','7','8','9'};
    char[] num = new char[n];
    int count = 0;
    public int[] printNumbers(int n){
        this.n=n;
        dfs(0);
        return res ;
    }
    public void dfs(int x){
        if(x==n){
            res[count++]=Integer.parseInt(num.toString());
            return ;
        }
        for(char c : loop) {
            num[x] = c;
            dfs(x + 1);
        }
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(printNumbers(1)));
    }


    class Solution {
        int nine,start,count,n;
        int[] res;
        char[] num,loop={'0','1','2','3','4','5','6','7','8','9'};
        public int[] printNumbers(int n) {
            this.n=n;
            res=new int[(int)Math.pow(10,n)-1];
            num=new char[n];
            start=n-1;
            count=0;
            nine=0;
            dfs(0);
            return res ;
        }
        public void dfs(int x){
            if(x==n){
                String val = String.valueOf(num).substring(start);
                if(!val.equals("0")) res[count++]=Integer.parseInt(val);
                if(n-start==nine) start--;
                return ;
            }
            for(char c  : loop){
                if(c=='9') nine++;
                num[x]=c;
                dfs(x+1);
            }
            nine--;
        }
    }


}
