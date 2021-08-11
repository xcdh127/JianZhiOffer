import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-11 18:53
 **/
public class JianZhi_34二刷 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        LinkedList<Integer> path = new LinkedList<Integer>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            recur(root,target);
            return res ;
        }
        public void recur(TreeNode root ,int target){
            if(root==null) return ;
            target-=root.val;
            path.add(root.val);
            if(target==0 && root.left==null && root.right==null){
                res.add(new LinkedList(path));
            }
            recur(root.left,target);
            recur(root.right,target);
            path.removeLast();
        }

    }

}
