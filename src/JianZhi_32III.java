import org.junit.Test;

import java.util.*;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第32题第三小题
 * @author: Mr.Sun
 * @create: 2021-06-19 19:17
 **/
public class JianZhi_32III {
    @Test
    public void test(){
        List list = new LinkedList();
        ((LinkedList) list).addFirst(1);
        ((LinkedList) list).addFirst(2);
        System.out.println(list);
    }


}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution005 {

    /*
    * 将奇数层的元素和偶数层的元素分别放到各自的栈中
    * 奇数层：从左到右遍历
    * 偶数层：从右向左遍历
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root == null){
            return res ;
        }
        stack1.push(root);
        int n = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(n%2 != 0){
                for(int i=stack1.size();i>0;i--){
                    TreeNode head = stack1.pop();
                    list.add(head.val);
                    if(head.left!=null){
                        stack2.push(head.left);
                    }
                    if(head.right!=null){
                        stack2.push(head.right);
                    }
                }
                res.add(list);
            }
            if(n%2 == 0){
                for (int i=stack2.size(); i>0; i--) {
                    TreeNode head = stack2.pop();
                    list.add(head.val);
                    if(head.right!=null){
                        stack1.push(head.right);
                    }
                    if(head.left!=null){
                        stack1.push(head.left);
                    }
                }
                res.add(list);
            }
            n++;
        }
        return res;
    }
}


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
* K神题解：每层都是从左到右遍历
* 使用双端队列存储：
* 奇数层从头入队
* 偶数层从尾入队
* */
class Solution006 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res ;
        }
        queue.offer(root);
        int n = 1;
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            if(n%2 != 0){
                for(int i=queue.size();i>0;i--){
                    TreeNode head = queue.poll();
                    list.add(head.val);
                    if(head.left!=null){
                        queue.offer(head.left);
                    }
                    if(head.right!=null){
                        queue.offer(head.right);
                    }
                }
                res.add(list);
            }
            if(n%2 == 0){
                for (int i=queue.size(); i>0; i--) {
                    TreeNode head = queue.poll();
                    list.addFirst(head.val);
                    if(head.left!=null){
                        queue.offer(head.left);
                    }
                    if(head.right!=null){
                        queue.offer(head.right);
                    }
                }
                res.add(list);
            }
            n++;
        }
        return res;
    }
}


