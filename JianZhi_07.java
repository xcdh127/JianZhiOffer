import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeJavaTest
 * @description: 重建二叉树
 * @author: Mr.Sun
 * @create: 2021-05-31 19:31
 **/
/*
* 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
*
* */
public class JianZhi_07 {
   public static Map<Integer,Integer> indexMap ;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        前序遍历序列的个数
        int n =preorder.length ;
//        新建一个集合存储节点
        indexMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
//            将中序遍历序列放到 MAP 中方便取到根节点
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    public static TreeNode myBuildTree(int[] preorder ,int[] inorder ,int preorder_left,int preorder_right,int inorder_left ,int inorder_right){
//        首先判断前序遍历preorder_left是否小于preorder_right，如果小于则继续执行，否则返回null
        if (preorder_left>preorder_right){
            return null ;
        }
//        1.先找到根节点，前序遍历第一个节点就是根节点
        int preorder_root = preorder_left ;
//        2.在中序遍历中找到根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
//        3.计算左子树节点的数量
        int size_left_subtree = inorder_root - inorder_left ;
//        4.造出根节点
//        将根节点的值赋值给根节点的值域
        TreeNode root = new TreeNode(preorder[preorder_root]);
//        5.递归构造左子树，并将左子树连接到根节点上
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);
//        6.递归构造右子树，并将右子树连接到根节点上
        root.right = myBuildTree(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,inorder_root+1,inorder_right);

        return root ;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);


    }



}

