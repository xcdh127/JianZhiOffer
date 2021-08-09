import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第55题
 * @author: Mr.Sun
 * @create: 2021-06-21 15:45
 **/
public class JianZhi_55 {



}
/*
* 一个思路：本想通过遍历二叉树，获得层数，但是遇到的问题是：二叉树每有一个孩子，值就会加 1；
* 代码如下：
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
class Solution010 {
    int numLeft = 1 ;  //树的深度(左支路)
    int numRight = 1 ; //树的深度(右支路)
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        preIndex(root);
        return numLeft>=numRight? numLeft:numRight;
    }
    public void preIndex(TreeNode root){
        if(root.left!=null){
            numLeft++;
            preIndex(root.left);
        }
        if(root.right!=null){
            numRight++;
            preIndex(root.right);
        }
    }
}

// 我的思路：通过程序遍历二叉树获得二叉树的深度，通过逐层遍历二叉树，每一层一个for循环，num++.最终成功
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution011 {
    // 思路：通过层序遍历二叉树获得二叉树的深度
    int num = 0;
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            //对二叉树逐层遍历，每一层遍历的个数就是当前队列的大小
            for(int i = queue.size();i>0;i--){
                TreeNode head = queue.poll();
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right!=null){
                    queue.add(head.right);
                }
            }
            num++;
        }
        return num;
    }
}



/*
* K神题解：使用递归的方式将子树的深度一层层的向上传递
* 如果这个树没有左子树，这棵树的最大深度就是左子树的深度+1；
* 如果这个树没有右子树，这课树的最大深度就是右子树的深度+1；
* 如果一个树没有子树那么它的深度为1；
* 如果一个树为空树，直接返回0.
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
class Solution012 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}


/*
* K神题解：广度优先算法，按照每一层进行统计，关键步骤：for(int i = queue.size();i>0;i--)这是按层的关键
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
class Solution013 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        int num = 0;
        if(root == null){
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i = queue.size();i>0;i--){
                TreeNode head = queue.poll();
                if(head.left!=null){
                    list.add(head.left);
                }
                if(head.right!=null){
                    list.add(head.right);
                }
                queue.addAll(list);
                list.clear();
            }
            num++;
        }
        return num ;
    }
}







