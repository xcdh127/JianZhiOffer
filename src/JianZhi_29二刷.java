/**
 * @program: LeetCodeJavaTest
 * @description: 29
 * @author: Mr.Sun
 * @create: 2021-07-31 15:57
 **/
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class JianZhi_29二刷 {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            //特殊处理
            if(matrix==null || matrix.length==0 ||matrix[0].length==0){
                return new int[0];
            }
            // 初始化
            int m = matrix.length;
            int n = matrix[0].length;
            int[] res = new int[m*n];
            int t = 0;
            int b=m-1;
            int l=0;
            int r=n-1;
            int x = 0;
            // 按照顺时针的方向遍历数组
            while(true){
                // 从左向右遍历
                for(int i=l;i<=r;i++){
                    res[x++]=matrix[t][i];
                }
                if(++t>b)break;
                // 从上到下遍历
                for(int i=t;i<=b;i++){
                    res[x++]=matrix[i][r];
                }
                if(--r<l)break;
                // 从右向左遍历
                for(int i=r;i>=l;i--){
                    res[x++]=matrix[b][i];
                }
                if(--b<t)break;
                // 从下向上遍历
                for(int i=b;i>=t;i--){
                    res[x++]=matrix[i][l];
                }
                if(++l>r)break;
            }
            return res ;
        }
    }

}
