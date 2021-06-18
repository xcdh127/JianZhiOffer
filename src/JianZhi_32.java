import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第32题
 * @author: Mr.Sun
 * @create: 2021-06-18 10:59
 **/
/*
*从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
*
 * */
public class JianZhi_32 {
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
//思路一：用一个队列来存储根元素，然后弹出一个元素，判断它是否有左右孩子，如果有左右孩子就将其放入队列中

    /*
    * 问题在于：数组的长度无法事先知道，所以最后输出带了过多的0
    * */
class Solution003 {
    public int[] levelOrder(TreeNode root) {
        // 1.创建一个队列，用于存放当前元素
        Queue queue = new LinkedList();
        // 2.将二叉树的根元素放在队列中
        queue.add(root);
        // 创建一个集合来存储节点的值
        List res = new ArrayList();
        int[] arr = new int[1000];

        int n = 0;
        // 3.下面开始循环操作；终止条件为队列为空
        while(!queue.isEmpty()){
            // 4.将队列的首元素弹出，如果这个弹出的元素有左右孩子，就将所有孩子存放到队列中
            TreeNode head = (TreeNode)queue.poll();
            // res.add(head.val);
            arr[n++]=head.val;
            // 5.将每次弹出的元素取值给一个数组,最后将数组的值
            if(head.left!=null){
                queue.offer(head.left);
            }
            if(head.right!=null){
                queue.offer(head.right);
            }
        }
        // return res.toArray(new int[]);
        return arr;
    }
}

/*
*
* get 到了新技能：先用集合存储元素，然后得到集合的大小，造同样大小的数组，将集合中的元素放到数组中返回
* */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution004 {
    public int[] levelOrder(TreeNode root) {
        // 1.创建一个队列，用于存放当前元素
        Queue queue = new LinkedList();
        // 2.将二叉树的根元素放在队列中
        queue.add(root);
        // 创建一个集合来存储节点的值
        List res = new ArrayList();
        // int[] arr = new int[1000];
        int n = 0;
        if(root==null){
            return new int[0];
        }
        // 3.下面开始循环操作；终止条件为队列为空
        while(!queue.isEmpty()){
            // 4.将队列的首元素弹出，如果这个弹出的元素有左右孩子，就将所有孩子存放到队列中
            TreeNode head = (TreeNode)queue.poll();
            res.add(head.val);
            // arr[n++]=head.val;
            // 5.将每次弹出的元素取值给一个数组,最后将数组的值
            if(head.left!=null){
                queue.offer(head.left);
            }
            if(head.right!=null){
                queue.offer(head.right);
            }
        }
        // 将集合中的元素取出来放到数组中返回
        int size = res.size();
        int[] arr = new int[size];
        for(int i =0; i<size;i++){
            arr[i] = (int)res.get(i);
        }
        return arr;
    }
}