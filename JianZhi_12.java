import org.junit.Test;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第12题
 * @author: Mr.Sun
 * @create: 2021-07-13 07:51
 **/
/*
* 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
* 如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

* */
public class JianZhi_12 {

    /*
    * K神题解：   搜索问题，使用深度优先遍历，从数组的左上角开始遍历，判断该位置的前后左右位置是不是当前
    *          字符数组中的字符，如果是返回true,返回false的情况有以下几种：
    *               （1）数组的行或者列索引越界；
    *               （2）当前元素已经访问过，或者不是当前字符数组的字符
    *               （3）字符数组的字符已经全部搜索完毕
    *
    * */
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,array,0,0,0))return true;
            }
        }
        return false ;
    }

    public boolean dfs(char[][] board,char[] word,int i ,int j,int k){
//        返回false的情况
        if (i<0||i>board.length||j<0||j>board[0].length||board[i][j]!=word[k])return false;
        if (k == word.length-1)return true ;
        board[i][j]='\0';
        boolean res = dfs(board,word,i-1,j,k+1)||dfs(board,word,i+1,j,k+1)
                ||dfs(board,word,i,j-1,k+1)||dfs(board,word,i,j+1,k+1);
        board[i][j]=word[k];
        return res ;
    }










}
