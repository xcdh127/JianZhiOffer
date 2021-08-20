import java.util.Stack;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-07 09:44
 **/
public class JianZhi_27二刷 {

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
    * 辅助栈方法
    * */
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            //如果树为空。返回null
            if(root==null) return null ;
            // 定义一个辅助栈
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                // 将栈顶节点弹出，并判是否有左右子树加入栈中
                TreeNode temp = stack.pop();
                // 如果当前节点的左右子树不为空，即不是叶子节点时，将当前节点的左右子树加入栈中
                if(temp.left!=null)stack.push(temp.left);
                if(temp.right!=null)stack.push(temp.right);
                // 交换左右子树
                TreeNode node = temp.left ;
                temp.left=temp.right ;
                temp.right=node ;
            }
            return root ;
        }
    }

}
