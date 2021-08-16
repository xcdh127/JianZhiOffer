import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-14 16:59
 **/
public class JianZhi_13二刷 {
    class Solution {
//        广度优先    bfs
        public int movingCount(int m, int n, int k) {
            boolean[][] visited=new boolean[m][n];
            Queue<int[]> queue=new LinkedList<int[]>();
            queue.add(new int[]{0,0,0,0});
            int res =0 ;
            while(!queue.isEmpty()){
                int[] temp = queue.remove();
                int i=temp[0];
                int j=temp[1];
                int s_i=temp[2];
                int s_j=temp[3];
                if(i>=m || j>=n || s_i+s_j>k ||visited[i][j])continue;
                visited[i][j]=true;
                res++;
                queue.add(new int[]{i+1,j,sum(i+1),sum(j)});
                queue.add(new int[]{i,j+1,sum(i),sum(j+1)});
            }
            return res ;
        }
        public int sum(int x){
        int res = 0;
        while(x>0){
            res+=x%10;
            x/=10;
        }
        return res ;
        }

//        深度优先    dfs
        class Solution01 {
            int m;
            int n;
            int k;
            public int movingCount(int m, int n, int k) {
                this.m=m;
                this.n=n;
                this.k=k;
                boolean[][] visited=new boolean[m][n];
                return dfs(0,0,visited);
            }
            public int dfs(int i,int j,boolean[][] visit){
                if(i>=m || j>=n || visit[i][j] || sum(i)+sum(j)>k)return 0;
                visit[i][j]=true;
                return 1+dfs(i+1,j,visit);
            }
        }

    }
}
