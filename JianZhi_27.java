import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第27题
 * @author: Mr.Sun
 * @create: 2021-06-16 10:58
 **/
/*
* 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
*
* */
public class JianZhi_27 {

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

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


// 思路一：使用二叉树层次遍历的思想（问题在于从队列弹出的节点如何构成一颗二叉树）
//         使用一个队列去存储二叉树遍历的结果：
//         如果当前节点有右孩子就将右孩子存入队列
//         如果点前节点有左孩子就将左孩子存入队列
//         每一次先将队首元素出队列


/*
* 问题解决：在每一次左右孩子入栈的时候，将该节点的左右孩子互换
*
*
* */



class Solution3 {
    public TreeNode mirrorTree(TreeNode root) {
        //新建一个队列，用于临时存储节点
        Queue queue = new LinkedList();
        TreeNode res = new TreeNode(0);
//   调用层次遍历
        cengCiBianLi(root,queue);

        return null ;
    }


    public TreeNode cengCiBianLi(TreeNode node,Queue queue){
        queue.offer(node);
        while(!queue.isEmpty()){
// 将队首元素出队
            TreeNode tn = (TreeNode)queue.poll();
// 如果当前元素有右孩子，将右孩子入队
            if(tn.right!=null){
                queue.offer(tn.right);
            }
// 如果当前元素有左孩子，将左孩子入队
            if(tn.left!=null){
                queue.offer(tn.left);
            }
            /*
            * 解决问题部分代码：交换左右孩子
            * */
            TreeNode temp = tn.left;
            tn.left = tn.right;
            tn.right = temp;
        }
        return node;
    }





//    思路二：前序遍历每一个节点。若当前节点存在左右孩子，则将该节点的左右孩子交换


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution5 {
        public TreeNode mirrorTree(TreeNode root) {
// 使用二叉树的前序遍历，遍历每一个节点，当前节点存在左右孩子时，就交换它的左右孩子
//    如果根节点为空，返回空
            if(root==null){
                return null;
            }
//    如果根节点没有左右孩子时，返回head
            if(root.left==null && root.right==null){
                return null;
            }
            // 如果当前节点不为空，交换该节点的左右子树
            // 新建一个节点用于交换
            // 定义一个索引指向当前位置
            while(root!=null){
                TreeNode  temp = new TreeNode(0);
                temp = root.left;
                root.left = root.right;
                root.right= temp;
//  对左子树递归前序遍历
                while(root.left!=null){
                    mirrorTree(root.left);
                }
//  对右子树递归前序遍历
                while(root.right!=null){
                    mirrorTree(root.right);
                }

            }

            return root;
        }
    }


//    K神题解：
//    思路：二叉树的前序遍历，镜像二叉树的左右孩子是互换的，因此在前序遍历二叉树时，将左右孩子进行互换即可。
//    首先将左孩子保存起来，因为遍历到右孩子后，将右孩子替换左孩子后，在遍历左孩子时，左孩子已经变化了，所以引入一个临时节点，
//    用来存放左孩子
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution4 {
        public TreeNode mirrorTree(TreeNode root) {
// 使用二叉树的前序遍历，遍历每一个节点，当前节点存在左右孩子时，就交换它的左右孩子
//    如果根节点为空，返回空
            if(root == null){
                return null;
            }
// //    如果根节点没有左右孩子时，返回head
            // if(root.left==null && root.right==null){
            //     return null;
            // }
            // 如果当前节点不为空，交换该节点的左右子树
            // 新建一个节点用于交换
            // 定义一个节点暂存当前节点的左子树
            TreeNode  temp =  root.left;
//  对右子树递归前序遍历，将结果给左子树
            root.left = mirrorTree(root.right);
//  对左子树递归前序遍历，将结果给右子树
            root.right = mirrorTree(temp);
            return root;
        }
    }





    /*
    * 用辅助队列的方式：精简版
    *
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
    class Solution6 {
        public TreeNode mirrorTree(TreeNode root) {
            Queue queue = new LinkedList() ;
            return   cengCiBianLi(root,queue);
        }

        public TreeNode cengCiBianLi(TreeNode node,Queue queue){
            if(node==null){
                return null;
            }
            queue.offer(node);
            while(!queue.isEmpty()){
                // 将队首元素出队
                TreeNode tn = (TreeNode)queue.poll();
                // 如果当前元素有右孩子，将右孩子入队
                if(tn.right!=null){
                    queue.offer(tn.right);
                }
                // 如果当前元素有左孩子，将左孩子入队
                if(tn.left!=null){
                    queue.offer(tn.left);
                }
//                交换左右孩子
                TreeNode temp = tn.left; ;
                tn.left=tn.right;
                tn.right=temp;
            }
            return node;
        }
    }









}