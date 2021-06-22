/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第68题
 * @author: Mr.Sun
 * @create: 2021-06-22 15:46
 **/
/*
*
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]


*
* */
public class JianZhi_68 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /*
    * 思路：搜索树是排序二叉树，我们可以通过比较当前节点的值，与传入的两个节点的值的大小关系来确定最低的公共祖先
    * 判断准则：
    * （1）如果当前节点的值比输入的两个节点的值都小，那么这两个值的最低公共祖先就在当前节点的右子树上，
    * 此时递归前序遍历右子树
    * （2）如果当前节点的值比输入的两个接线的值都大，那么这两个值的最低公共祖先就在当前节点的左子树上，
    * 此时递归前序遍历左子树
    * （3）当第一次遍历到介于两个输入节点大小之间的值时，返回当前节点，这个点就是输入的两个节点的最低公共祖先。
    *
    *
    *
    * */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null ;
            }
            if(root.val >= Math.min(p.val, q.val) && root.val <=Math.max(p.val, q.val)){
                return root ;
            }
            if(root.val > Math.max(p.val, q.val)){
                return  lowestCommonAncestor(root.left, p, q);
            }
            if(root.val < Math.min(p.val, q.val)){
                return  lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
