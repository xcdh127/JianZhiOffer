import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-09 18:48
 **/
public class JianZhi_55I二刷 {
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
        public int maxDepth(TreeNode root) {
            if(root==null)return 0;
            List<TreeNode> stack =new LinkedList<TreeNode>();
            stack.add(root);
            int num =0;
            while(!stack.isEmpty()){
                List<TreeNode> list =new ArrayList<TreeNode>();
                for(TreeNode node : stack){
                    if(node.left!=null) list.add(node.left);
                    if(node.right!=null) list.add(node.right);
                }
                stack=list;
                num++;
            }
            return num ;
        }
    }



}
