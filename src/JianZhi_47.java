/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第47题
 * @author: Mr.Sun
 * @create: 2021-07-15 19:55
 **/
/*
* 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
* 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
* 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

* */

public class JianZhi_47 {

    /*
    * K神题解：动态规划题，思路是定义dp数组的含义，本题定义dp[i]的含义是：当遍历到数组的第[i][j]元素时，礼物值的最大值
    *                                         初始值 dp[0][0]=grid[0][0]，从左上角开始寻找；
    *                                         当i=0时，说明在遍历数组的第一行，这时候只能够是从左向右走，dp[i][j]=dp[i][j-1]+grid[i][j]
    *                                         当j=0时，说明在遍历数组的第一列，这时候只能够是从上向下走，dp[i][j]=dp[i-1][j]+grid[i][j]
    *                                         当i!=0并且j!=0时，说明此时在数组的中间，既可以从上到下经过也可以从左到右经过
    *
    *
    * */

    public int maxGrid(int[][] grid){
//        定义一个辅助的二位数组
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp =new int[m][n];
//        遍历礼物二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }
                if (i!=0&&j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                if (i==0&&j!=0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                if (i!=0&&j!=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }


    /*
    * K神题解：优化   由于本题dp[i][j]只与dp[i-1][j]和dp[i][j-1]有关系，所以可以直接使用二维数组grid作为dp使用
    *                当i=0,j=0时为初始值，不对grid数组做任何操作，当i=0并且j！=0时，grid[i][j]=grid[i][j-1]+dp[i][j];
    *                当i!=0并且j=0时，grid[i][j]=grid[i-1][j]+grid[i][j]；
    *                当i!=0并且j!=0时，grid[i][j]=Math.max(grid[i][j-1],grid[i-1][j])+grid[i][j]
    *
    * */

    public int maxValue(int[][] grid){
        for (int i =0;i<grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (i==0&&j==0){
                    continue;
                }else if (i==0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }else if(j==0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }else{
                    grid[i][j]=Math.max(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }













}





