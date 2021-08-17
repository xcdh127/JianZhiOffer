/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-16 18:10
 **/
public class JianZhi_47二刷 {

    class Solution {
        public int maxValue(int[][] grid) {
            int m=grid.length-1;
            int n=grid[0].length-1;
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    if(i==0 &&j==0)continue;
                    else if(i==0) grid[i][j]=grid[i][j-1]+grid[i][j];
                    else if(j==0) grid[i][j]=grid[i-1][j]+grid[i][j];
                    else{
                        grid[i][j]=Math.max(grid[i-1][j],grid[i][j-1])+grid[i][j];
                    }
                }
            }
            return grid[m][n];
        }
    }

}
