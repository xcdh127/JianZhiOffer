/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-12 17:56
 **/
public class JianZhi_36二刷 {


  class Node {
      public int val;
      public Node left;
      public Node right;

      public Node() {}

      public Node(int _val) {
          val = _val;
      }

      public Node(int _val,Node _left,Node _right) {
          val = _val;
          left = _left;
          right = _right;
      }
  };

    class Solution {
        Node head ;
        Node pre ;
        public Node treeToDoublyList(Node root) {
            if(root==null)return null ;
            recur(root) ;
            pre.right=head;
            head.left=pre;
            return head ;
        }
        public void recur(Node cur){
            if(cur==null)return ;
            recur(cur.left);
            if(pre==null)head=cur;
            else pre.right=cur;
            cur.left=pre;
            pre=cur;
            recur(cur.right);
        }
    }

}
