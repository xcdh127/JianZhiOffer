import org.junit.Test;
import sun.reflect.generics.tree.Tree;
import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第34题
 * @author: Mr.Sun
 * @create: 2021-06-24 18:36
 **/
/*
* 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
* 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
* 示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]

思路：前序遍历二叉树，在遍历的过程中记录走过的路径，每走一步就将target值减去当前节点的值，直到target为0，并且当前遍历到了叶子结点，
每遍历都要将路径最后放进去的左孩子去掉，以便添加右孩子。


*/
public class JianZhi_34 {
    public class TreeNode {
      int val;TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
      }
  }

    class Solution {
        //            定义一个链表的链表
        List<List<Integer>> res = new ArrayList<>();
        //            定义一个存放路径 path 的链表
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
//            从根节点开始递归前序遍历
            recur(root,target);
//           因为上述函数遇到叶子结点会直接返回，所以这里直接返回结果即可。
            return res ;
        }


//        编写一个前序遍历二叉树的递归函数
        public void recur(TreeNode root,int target){
//            当遍历到叶子节点时直接返回
            if(root == null){
                return ;
            }
//            target值减去当前节点的值
            target = target - root.val;
//            将当前节点放到存放路径的链表 path 中
            path.add(root.val);
//            如果当前 target值为 0 ,并且当前节点时叶子节点，即将当前 path 放到结果 res 链表中
            if (target == 0 && root.left == null && root.right == null){
                res.add(new ArrayList<>(path));
            }
//          递归前序遍历左子树
            recur(root.left,target);
//          递归前序遍历右子树
            recur(root.right,target);
//            将上一步放到路径链表的左子树的值删除,目的是存放接下来右子树的值，形成另一条路径
            path.removeLast();

        }
        @Test
        public void test(){

        }
    }
















}
