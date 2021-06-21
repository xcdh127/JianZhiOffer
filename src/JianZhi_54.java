import com.sun.org.apache.xpath.internal.operations.Plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第54题
 * @author: Mr.Sun
 * @create: 2021-06-21 10:26
 **/
public class JianZhi_54 {
//思路一：将二叉树前遍历，并且将结果存放到一个list集合中，
// 将问题转化为对集合内的元素进行排序，然后将第K大的数值进行输出


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
        public int kthLargest(TreeNode root, int k) {
            if(k==0){
                return -1;
            }
            if(root==null){
                return -1;
            }
            List<Integer> list = new ArrayList<>();
            list = preIndex(root,list);
            int size = list.size();
            int[] arr = new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = list.get(i);
            }
            Arrays.sort(arr);
            return arr[size-k];
        }

        public List<Integer> preIndex(TreeNode root,List<Integer> list){
            if(root!=null){
                list.add(root.val);
            }
            if(root.left!=null){
                list = preIndex(root.left,list);
            }
            if(root.right!=null){
                list = preIndex(root.right,list);
            }
            return list ;
        }

    }


//    思路二：根据二叉树的结构可以看出，通过二叉树的中序遍历，就是这个二叉树各个元素的升序排序
//    所以采用二叉树的中序遍历方式：左====>根====>右

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution008 {
        public int kthLargest(TreeNode root, int k) {
            if(k==0){
                return -1;
            }
            if(root==null){
                return -1;
            }
            List<Integer> list = new ArrayList<>();
            list = preIndex(root,list);
            int size = list.size();
            return list.get(size-k);
        }

        public List<Integer> preIndex(TreeNode root,List<Integer> list){
            if(root.left!=null){
                list = preIndex(root.left,list);
            }
            if(root!=null){
                list.add(root.val);
            }
            if(root.right!=null){
                list = preIndex(root.right,list);
            }
            return list ;
        }

    }

//    K神题解：  只需要进行一个先右子树，后根节点，最后左子树的递归遍历即可
//    定义两个成员变量，将结果和 K值定义为成员变量，在递归过程中使用的 K和返回的结果就能共享了

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
        int k ;//成员变量K，用于计数，输出逆序的第K个数
        int num;//成员变量 num,用于将第 K个值输出。

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
//通过观察发现，二叉树的中序遍历的第K大的数字，就是二叉树中序遍历的逆序的第K个数字，所以可以采用的遍历顺序是：右==>根==>左
            innerIndexReserve(root);
            return num;

        }
        public void innerIndexReserve(TreeNode root){
            if(root==null){
                return ;
            }
            if(root.right!=null){
                innerIndexReserve(root.right);
            }
            k--;
            if(k == 0){
                this.num =  root.val;
            }
            if(root.left!=null){
                innerIndexReserve(root.left);
            }

        }

    }











}
