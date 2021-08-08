/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-07 21:00
 **/
public class JianZhI_28二刷 {

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
        public boolean isSymmetric(TreeNode root) {
            if(root==null) return true;
            return isEqual(root.left,root.right);
        }

        public boolean isEqual(TreeNode left,TreeNode right){
            if(left==null && right==null)return true ;
            if(left==null || right==null)return false ;
            return left.val==right.val && isEqual(left.left,right.right) && isEqual(left.right,right.left);
        }


    }
}
