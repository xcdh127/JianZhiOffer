import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-12 18:44
 **/
public class JianZhi_37二刷 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  LinkedList<TreeNode> stack = new LinkedList<>();
  StringBuilder sb = new StringBuilder();
  public String serialize(TreeNode root){
      if (root==null) return "[]";
  sb.append("[");
  stack.add(root);
  while(!stack.isEmpty()){
      TreeNode temp = stack.remove();
      if(temp==null) sb.append("null,");
      else sb.append(temp.val+",");
      if(temp!=null){
          stack.add(temp.left);
          stack.add(temp.right);
      }
  }
  sb.deleteCharAt(sb.length()-1);
  sb.append("]");
  return sb.toString();
  }
  @Test
public void test(){
      TreeNode head = new TreeNode(1);
      TreeNode head1 = new TreeNode(2);
      TreeNode head2 = new TreeNode(3);
      head.left=head1;
      head.right=head2;
      head=null ;
      System.out.println(serialize(head));
  }
    @Test
  public void test1(){
      String test = "[]";
      System.out.println(test.substring(1, test.length() - 1));
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "[]";
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            stack.add(root);
            while(!stack.isEmpty()){
                TreeNode temp = stack.remove();
                if(temp==null) sb.append("null,");
                else sb.append(temp.val+",");
                if(temp!=null){
                    stack.add(temp.left);
                    stack.add(temp.right);
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data=="[]")return null;
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            String[] str = data.substring(1,data.length()-1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(str[0]));
            queue.add(root);
            int i = 1 ;
            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                if(!str[i].equals("null")){
                    node.left=new TreeNode(Integer.parseInt(str[i]));
                    queue.add(node.left);
                }
                i++;
                if(!str[i].equals("null")){
                    node.right=new TreeNode(Integer.parseInt(str[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root ;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


}
