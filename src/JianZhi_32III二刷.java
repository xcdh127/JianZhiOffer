import java.util.*;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-08 14:16
 **/
public class JianZhi_32III二刷 {

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
            int num = 0;
            while(!deque.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                int size = deque.size();
                for(int j = 0;j<size;j++){
                    TreeNode temp = deque.removeFirst();
                    if(temp.left!=null) deque.add(temp.left);
                    if(temp.right!=null) deque.add(temp.right);
                    list.add(temp.val);
                }
                if(num % 2 != 0 ) Collections.reverse(list);
                num++;
                res.add(list);
            }
            return res ;
        }
    }


}
