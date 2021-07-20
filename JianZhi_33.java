import org.junit.Test;

import java.util.function.BiFunction;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第33题
 * @author: Mr.Sun
 * @create: 2021-07-20 18:19
 **/
/*
*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
如果是则返回 true，否则返回 false。
假设输入的数组的任意两个数字都互不相同。
参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
* */

public class JianZhi_33 {
    /*
    * K神题解：  二叉搜索树后序遍历的特点：
    *            数组最后一个数字是根节点，大于根节点的数字都在根节点的右边
    *            小于根节点的数字都在根节点的左边。
    *            定义指针：i,j，p设置j指向当前要遍历数组的最后一个数字
    *                     i指向当前数组的第一个数字，p指针从头遍历当前数组，
    *                     直到遇到第一个大于最后一个数字的数字，把当前指针位置记录下来，
    *                     继续向后遍历，遇到小于最后一个数字的数字跳出，
    *                     最后返回是否是二叉树的后序遍历
    *
    *
    * */
    public boolean isTure(int[] arr){
        return recur(arr,0,arr.length-1);
    }


    public boolean recur(int[] arr , int i ,int j){
//        当 i>=j时,表示只有一个节点，不用判断，直接返回是二叉搜索树
        if (i >= j){
            return true ;
        }
//        定义一个指针 p
        int p = i;
        while (arr[p]<arr[j]){
            p++;
        }
        int m = p;
        while (arr[p]>arr[j]){
            p++;
        }
        return p==j&&recur(arr,i,m-1)&&recur(arr,m,j-1);

    }


    @Test
    public void test(){
        int[] arr ={4, 8, 6, 12, 16};
        System.out.println(isTure(arr));

    }

















}
