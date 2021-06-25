import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第37题
 * @author: Mr.Sun
 * @create: 2021-06-25 19:15
 **/
/*
* 请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
* */
public class JianZhi_37 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // 通过层次遍历将二叉树序列化，子节点的null值也要输出
            if(root == null){
                return "[]";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            //用于拼接字符串
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(root == null){
                return null;
            }
            queue.offer(root);
//            队列不为空时层序遍历二叉树，因为 null 值也要输出，所以不需要判断左右子树是否为空。当节点为空时输出 null 值
            while(!queue.isEmpty()){
                TreeNode head = queue.poll();
                if(head!=null){
                    sb.append(head.val+",");
                    queue.offer(head.left);
                    queue.offer(head.right);
                }else{
                    sb.append("null,");
                }
            }
            sb.substring(0, sb.length()-1);
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("[]")){
                return null;
            }
            String[] arr = data.substring(1,data.length()-1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            int i = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
//            根据观察，当树的当前节点前面有 m个null值时，那么  当前节点左子树的索引为：2*(n-m)+1
//                                                          当前节点右子树的索引为：2*(n-m)+2
//            根据上述规则重构二叉树，分别递归构建当前节点的左右子树，索引每次递增 1
//            每次构建一个节点，就把该节点放到队列里面，好继续构建它的左右子树
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(!arr[i].equals("null")){
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    queue.offer(node.left);
                }
                i++;
                if(!arr[i].equals("null")){
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}

