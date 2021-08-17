import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-17 09:27
 **/
public class JianZhi_46二刷 {

    class Solution {
        public int translateNum(int num) {
            String s=String.valueOf(num);
            int n=s.length();
            int[] dp = new int[n+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                String str=s.substring(i-2,i);
                if(str.compareTo("10")>=0 && str.compareTo("25")<=0){
                    dp[i]=dp[i-1]+dp[i-2];
                }else{
                    dp[i]=dp[i-1];
                }
            }
            return dp[n];
        }
    }



    @Test
    public void test(){
        int num=21456;
        System.out.println(String.valueOf(num));
        boolean flag = false;
        String s = String.valueOf(num);
        if(s.compareTo("10")>=0 && s.compareTo("25")<=0)flag=true;
        System.out.println(s.substring(0, 2));
        System.out.println(flag);


    }
}
