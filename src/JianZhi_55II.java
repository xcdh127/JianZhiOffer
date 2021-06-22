/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第55题第2小题
 * @author: Mr.Sun
 * @create: 2021-06-22 13:19
 **/
/*
*
* 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
* 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
*
* */
public class JianZhi_55II {

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
        //思路：先统计各个孩子的深度，一旦有
        //左右孩子的深度相差超过1时就返回false.（利用了上一道题目求树的深度的算法思路）
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            // 获取当前节点左子树的深度
            int leftNum = dthTree(root.left);
            // 获取当前节点右子树的深度
            int rightNum = dthTree(root.right);
            // 当左右子树的深度差大于1时，返回false.
            if(Math.abs(leftNum-rightNum)>1){
                return false;
            }
            //左右孩子都是平衡二叉树，这棵树才是一颗平衡二叉树
            return isBalanced(root.left) && isBalanced(root.right);

        }
        public int dthTree(TreeNode root){
            if(root == null){
                return 0;
            }
            int leftNum = dthTree(root.left);
            int rightNum = dthTree(root.right);
            return Math.max(leftNum+1,rightNum+1);
        }

    }


    /*
    * K神题解：
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
    class Solution013 {
        //思路：使用后序遍历二叉树，每一次遍历到父节点统计值加 1 ,并且同时比较左右子树的深度是否 <=1 ,如果<=1就将
//        左右子树较大的深度 +1,向上返回; 如果左右子树的深度 >1 直接返回 -1，说明该子树不是平衡二叉树。


        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;

        }
        public int recur(TreeNode root){
            int leftNum = 0 ;
            int rightNum = 0 ;
            if(root == null){
                return 0 ;
            }
            if(root.left!=null){
                leftNum = recur(root.left);
            }
//            如果左子树不是平衡二叉树，直接返回 -1
            if(leftNum == -1){
                return -1 ;
            }
//            如果右子树不是平衡二叉树，直接返回 -1
            if(root.right!=null){
                rightNum = recur(root.right);
            }
            if(rightNum == -1){
                return -1 ;
            }
            return Math.abs(leftNum-rightNum)<2 ? Math.max(leftNum+1,rightNum+1):-1;
        }
    }




}
