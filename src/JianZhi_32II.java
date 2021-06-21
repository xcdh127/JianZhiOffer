import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第32题第二小题
 * @author: Mr.Sun
 * @create: 2021-06-18 16:52
 **/
public class JianZhi_32II {
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
            List<List<Integer>> res = new ArrayList<>();
            Queue queue = new LinkedList();
            List<Integer> list ;
            if(root == null){
                return null;
            }
            queue.offer(root);
            list = new ArrayList();
            // int toPrint = 1 ;
            int n = 1;
            while(!queue.isEmpty()){
                for(int i = n ;i>=0;i--){
                    TreeNode head = (TreeNode)queue.poll();
                    // toPrint--;
                    list.add(head.val);
                    // if(toPrint == 0){
                    // res.add(list);
                    // list = new ArrayList();
                    // }
                    if(head.left!=null){
                        queue.offer(head.left);
                        n++;
                    }
                    if(head.right!=null){
                        queue.offer(head.right);
                        n++;
                        // toPrint = n;
                    }
                }
                TreeNode head = (TreeNode)queue.poll();
                // toPrint--;
                list.add(head.val);
                // if(toPrint == 0){
                // res.add(list);
                // list = new ArrayList();
                // }
                if(head.left!=null){
                    queue.offer(head.left);
                    n++;
                }
                if(head.right!=null){
                    queue.offer(head.right);
                    n++;
                    // toPrint = n;
                }
            }
            return res ;
        }
    }


}
