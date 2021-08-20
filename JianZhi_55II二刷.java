/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-09 18:48
 **/
public class JianZhi_55II二刷 {
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
        public boolean isBalanced(TreeNode root) {
            if(root==null) return true ;
            return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right) ;
        }

        public int depth(TreeNode node){
            if(node==null) return 0;
            int left=depth(node.left);
            int right=depth(node.right);
            return Math.max(left,right)+1;
        }

    }



}
