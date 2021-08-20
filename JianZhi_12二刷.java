/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-14 10:35
 **/
public class JianZhi_12二刷 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            if(board==null||board.length==0||board[0].length==0)return false;
            char[] words=word.toCharArray();
            int m=board.length;
            int n=board[0].length;
            int index=0;
            boolean[][] helper = new boolean[m][n];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(search(board,words,i,j,index,helper))return true;
                }
            }
            return false;
        }

        public boolean search(char[][] board,char[] words,int i,int j,int index,boolean[][] helper){
            if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || helper[i][j] || board[i][j]!=words[index])return false;
            if(index==words.length-1)return true;
            helper[i][j]=true;
            index++;
            boolean res= search(board,words,i+1,j,index,helper)||search(board,words,i-1,j,index,helper)||search(board,words,i,j-1,index,helper)||search(board,words,i,j+1,index,helper);
            helper[i][j]=false;
            return res;
        }
    }
}
