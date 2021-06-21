/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第26题
 * @author: Mr.Sun
 * @create: 2021-06-20 20:05
 **/
public class JianZhi_26 {





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
class Solution007 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        //1.遍历A树节点，判断其值是不是和B树的根节点值相等
        // 用isSubStructure来遍历A树的孩子节点是否和B的根节点相等
        //2.如果A树当前节点的值与B树根结点值相等，就继续比较它的左右孩子是不是相等
        // 当A树为空了，说明B树还没有匹配完全，所以返回false;当B树为空了，说明B树和A树已经匹配完了，B树是A树的子树。
        if(A!=null && B!=null){
            if(A.val==B.val){
                result = isTreeAHasTreeB(A,B);
            }
            if(!result)
                result = isSubStructure(A.left,B);
            if(!result)
                result = isSubStructure(A.right,B);
        }
        return result ;
    }
    public boolean isTreeAHasTreeB(TreeNode left,TreeNode right){
        if(right==null){
            return true;
        }
        if(left==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isTreeAHasTreeB(left.left, right.left) && isTreeAHasTreeB(left.right, right.right);
    }
}