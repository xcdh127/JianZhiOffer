import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-08 14:21
 **/
public class JianZhi_32I二刷 {

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
        public int[] levelOrder(TreeNode root) {
            if(root==null) return new int[0]    ;
            List<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            deque.add(root);
            while(!deque.isEmpty()){
                TreeNode temp = deque.removeFirst();
                if(temp.left!=null) deque.add(temp.left);
                if(temp.right!=null) deque.add(temp.right);
                res.add(temp.val);
            }
            int size = res.size();
            int[] arr =new int[size];
            for(int i=0;i<size;i++){
                arr[i]=res.get(i);
            }
            return arr ;
        }
    }
}

