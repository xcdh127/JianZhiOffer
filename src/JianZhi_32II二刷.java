import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-08 14:20
 **/
public class JianZhi_32II二刷 {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null) return new ArrayList<List<Integer>>() ;
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            deque.add(root);
            while(!deque.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                int size = deque.size();
                for(int i=0;i<size;i++){
                    TreeNode temp = deque.removeFirst();
                    if(temp.left!=null)deque.addLast(temp.left);
                    if(temp.right!=null)deque.addLast(temp.right);
                    list.add(temp.val);
                }
                res.add(list);
            }
            return res ;
        }
    }
}
