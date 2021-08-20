/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-08 17:28
 **/
public class JianZhi_54二刷 {


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
        int k ;
        int res ;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            recur(root);
            return res ;
        }

        public void recur(TreeNode node){
            if(node==null) return ;
//            递归遍历右子树
            recur(node.right);
//            将K值减一
            if(k==0)return ;
            k--;
            if(k==0) {
                res=node.val;
            }
//            递归遍历左子树
            recur(node.left);
        }


    }
}
