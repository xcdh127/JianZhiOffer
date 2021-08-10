/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-10 19:47
 **/
public class JianZhi_68II二刷 {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 特例处理，当根节点为空，返回null
            if(root == null) return null ;
            //当根节点就是p或者q时，直接返回root
            if(root==q || root==p) return root;
            // 前序遍历左子节点，返回值记为left
            TreeNode left =lowestCommonAncestor(root.left,p,q);
            // 前序遍历右子节点，返回值记为right
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            // 如果左子树返回值为空说明，p q 都在右子树
            if(left == null)return right ;
            // 如果右子树返回值为空说明，p q 都在左子树
            if(right == null)return left ;
            // 如果左子树为空，右子树也为空 返回null
            if(right==null &&left==null)return null ;
            // 这一步说明左子树返回值不为空，右子树返回值也不为空,说明p q 分属于root的两侧
            // 返回 root 即可
            return root ;
        }
    }
}
