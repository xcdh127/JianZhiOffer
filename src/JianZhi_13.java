import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第13题
 * @author: Mr.Sun
 * @create: 2021-07-11 07:40
 **/
/*
* 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
* 一个机器人从坐标 [0, 0] 的格子开始移动，
* 它每次可以向左、右、上、下移动一格（不能移动到方格外），
* 也不能进入行坐标和列坐标的数位之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
* 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
* */
public class JianZhi_13 {
    /*
    * K神题解：(DFS) 使用深度优先算法   搜索可到达的格子，由于机器人每次移动一格，可以通过数位和增量求取当前位置的数位和
    *          可达域为直角三角形，所以搜索方法为两个方向，向下或者向右搜索。
    *
    *          不可达域特点：（1）行或者列超出了数组边界
    *                        （2）数位和超过 K
    *                        （3）这个位置前面已经搜索过了
    *
    *         可以到达的格子树由三部分组成：（1）当前（i,j）格子
    *                                      （2）（i,j）下方的可到达的格子数
    *                                      （3） （i,j）右方的可到达的格子数
    *          使用数组来辅助这个格子是否已经搜索过了
    * */
    boolean[][] visited ;
    int m ;
    int n ;
    int k ;
    public int movingCounts(int m,int n ,int k){
        this.m = m ;
        this.n = n ;
        this.k = k ;
        visited = new boolean[m][n];
        return dfs(0,0,0,0);

    }

    public int dfs(int i ,int j ,int s_i,int s_j ){
//        不可达域直接返回 0
        if (i>=m || j>=n || s_i+s_j>k || visited[i][j]) return 0 ;
        visited[i][j] = true ;
//        1+下方格子数+右方格子数
        return 1+dfs(i+1,j,((i+1)%10!=0)?s_i+1:s_i-8,s_j)+dfs(i,j+1,s_i,((j+1)%10!=0)?s_j+1:s_j-8);
    }

    @Test
    public void test(){
        System.out.println(movingCounts(2, 3, 1));
        solution2 solution2 = new solution2();
        System.out.println(solution2.RunningCounts(2, 3, 1));
    }





}
class solution2{
    /*
     * K神题解： BFS （广度优先） 先将（0,0）放入队列，然后依次放入这个格子下方和右方的格子
     *          出队列的格子 根据可达 不可达条件放入可行域中
     *          不可达条件：（1）行或者列索引越界
     *                      （2）数位和超过了K
     *                      （3）当前的位置已经搜索过了
     *     用队列弹出时，放入这个元素 下方和右方的元素
     * */
    int m ;
    int n ;
    int k ;
    public int RunningCounts(int m,int n,int k){
        this.m = m ;
        this.n = n ;
        this.k = k ;
//        辅助当前元素是否已经访问过
        boolean[][] visited = new boolean[m][n];
        int[] init = {0,0,0,0};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(init);
        int res = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            int s_i = temp[2];
            int s_j = temp[3];
//            当前位置是不可达区域时，直接跳过
            if (i>=m||j>=n||s_i+s_j>k||visited[i][j])continue;
            visited[i][j] = true ;
            res ++ ;
//                将下方元素以及位数和入队列
            queue.add(new int[]{i+1,j,((i+1)%10)!=0?s_i+1:s_i-8,s_j});
//                将右方元素以及位数和入队列
            queue.add(new int[]{i,j+1,s_i,((j+1)%10)!=0?s_j+1:s_j-8});
        }
        return res ;
    }

}

