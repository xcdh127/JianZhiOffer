/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-11 18:54
 **/
public class JianZhi_26二刷 {
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(A==null || B==null) return false ;
            return recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
        public boolean recur(TreeNode A,TreeNode B){
            if(B==null) return true ;
            if(A==null) return false ;
            if(A.val!=B.val) return false;
            return recur(A.left,B.left) && recur(A.right,B.right);
        }
    }
}
