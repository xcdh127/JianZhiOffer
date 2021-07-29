/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第19题
 * @author: Mr.Sun
 * @create: 2021-07-29 20:21
 **/

/*
* 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
* 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
* 在本题中，匹配是指字符串的所有字符匹配整个模式。
* 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
* */
public class JianZhi_19 {
    public boolean isMatch(String s, String p) {
//       K神题解： 使用动态规划思路：
//        s[:,i] p[:,j]表示 s的前i位，与p的前j位匹配，定义一个dp矩阵，记录匹配情况
        int m = s.length()+1;
        int n = p.length()+1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true ;
        for (int j = 2;j<n;j+=2){
            dp[0][j]=dp[0][j-2]&&p.charAt(j-1)=='*';
        }
        for (int i=1;i<m;i++){
            for (int j =1;j<n;j++){
                dp[i][j]=p.charAt(j-1)=='*'?
            dp[i][j-2]||dp[i-1][j]&&(p.charAt(j-2)=='.'||s.charAt(i-1)==p.charAt(j-2)):
            dp[i-1][j-1]&&(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.');
            }
        }
        return dp[m-1][n-1];
    }
}
