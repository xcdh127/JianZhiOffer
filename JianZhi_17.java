/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第17题
 * @author: Mr.Sun
 * @create: 2021-07-04 22:36
 **/
/*
* 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
* 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

* */

public class JianZhi_17 {

    /*
    * 思路一：计算10^n-1，然后从1输出到10^n-1；但是这样没有考虑大数问题，当数字很大的时候，我们没有办法用 int 或 long类型表示它。
    *
    * */

    class Solution {
        public int[] printNumbers(int n) {
            int num = 1;
            for(int i = 0;i<n;i++){
                num*=10;
            }
            int[] nums = new int[num-1];
            for(int i =0;i<num-1;i++){
                nums[i] = i+1 ;
            }
            return nums;
        }
    }

    /*
    * 思路二：K神题解 ：考虑大数问题，用字符串表示大数；固定某位数字，递归其他位置的全排列；去掉前导零，以及全为 9时，从1开始，其他情况从 0开始；
    * */

    class Solution01 {
        int[] res ;
        int nine ;
        int count =0;
        int start;
        int n ;
        char[] num,loop={'0','1','2','3','4','5','6','7','8','9'};
        public int[] printNumbers(int n) {
            this.n = n;
            // 用于拼接字符串
            res = new int[(int)(Math.pow(10, n))-1];
            num = new char[n];
            start = n-1 ;
            // 全排列递归
            dfs(0);
            return res;

        }

        public void dfs(int x){
            if(x == n){
                String s = String.valueOf(num).substring(start);
                if(!s.equals("0")){
                    res[count++] = Integer.parseInt(s);}
                if(n-start==nine){
                    start -- ;
                }
                return ;
            }
            for (char c : loop) {
                if(c == '9'){
                    nine ++ ;
                }
                num[x] = c;
                dfs(x+1);
            }
            nine -- ;
        }

    }






}
