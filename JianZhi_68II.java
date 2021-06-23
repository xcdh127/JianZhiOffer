/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第68题第2小题
 * @author: Mr.Sun
 * @create: 2021-06-23 13:13
 **/
public class JianZhi_68II {
    /*
    *给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
    * */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        // 后序遍历二叉树，当当前便利的节点为p,或者q时返回当前根节点。
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 特殊处理：根节点为null，返回null；p,或者q是root节点，直接返回root
            if(root == null || p == root || q == root){
                return root ;
            }
            // 后序递归调用左子树
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            // 后序递归调用右子树
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            // 如果左子树返回null ,说明左子树没有p或者q；返回右子树。
            if(left == null) return right ;
            // 如果右子树返回null ,说明右子树没有p或者q；返回左子树。
            if(right == null) return left ;
            // 如果左右子树都不为空，说明p，或者q分属root的两侧，直接返回root
            return root ;
        }
    }
}
