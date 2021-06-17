import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第28题
 * @author: Mr.Sun
 * @create: 2021-06-17 13:25
 **/
/*
* 请实现一个函数，用来判断一棵二叉树是不是对称的。
* 如果一棵二叉树和它的镜像一样，那么它是对称的。
*
* */
public class JianZhi_28 {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//思路一：先将二叉树变成镜像二叉树，然后和之前的二叉树比较。
    /*
    * 问题在于：将二叉树保存的是内存地址，最后指向相同的内存地址所以每个都是 true
    * */

class Solution001 {
    public boolean isSymmetric(TreeNode root) {
        TreeNode res = mirrorTree(root);
        //2. 判断当前root与保存的root是否相等
        return res.equals(root);
    }


    public TreeNode mirrorTree(TreeNode root){
        //1. 先将root保存起来，然后把二叉树整成镜像的
        if(root == null){
            return null;
        }
        //   1.1保存root节点
        TreeNode save = root;
        Queue queue = new LinkedList();
        queue.offer(root);
        TreeNode head =null;
        while(!queue.isEmpty()){
            head = (TreeNode)queue.poll();
            if(head.left!=null){
                queue.offer(head.left);
            }
            if(head.right!=null){
                queue.offer(head.right);
            }
            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;
        }
        return root;
    }


}
//
class Solution002{
//K神题解：
//    根据观察对称的二叉树，
//1.他的左孩子的值等于他的右孩子的值
//2.他的左孩子的左孩子的值等于他的右孩子的右孩子的值 && 他的左孩子的右孩子的值等于她的右孩子的左孩子的值
public boolean isSymmetric(TreeNode root) {
    return root==null ? true:recur(root.left,root.right);
    //2. 判断当前root与保存的root是否相等
}


//    定义一个函数来递归的判断是不是符合以上两个情况

    public boolean recur(TreeNode left, TreeNode right){
//        如果左孩子和右孩子都为空，返回true
        if (left==null && right==null) return true;
//        如果左孩子和右孩子有一个不为空，一个为空，返回false
        if (left==null || right==null) return false;
//        如果左孩子和右孩子不相等，返回false
        if (left.val!=right.val) return false;
//        如果左孩子的左孩子和右孩子的右孩子不相等 返回false
        return recur(left.left,right.right) && recur(left.right,right.left);
    }
}




















