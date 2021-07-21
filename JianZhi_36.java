/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第36题
 * @author: Mr.Sun
 * @create: 2021-07-21 19:38
 **/
/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
* 要求不能创建任何新的节点，只能调整树中节点指针的指向。
* */
public class JianZhi_36 {
    /*
    * K神题解：二叉搜索树的特点，（1）中序遍历的结果是递增排序的序列，题目要求转换成排序的列表，所以考虑使用中序遍历
    *             （2）链表有前驱节点和后继节点，考虑在中序遍历二叉树的过程中，建立前驱和后继节点之间的联系
    *             （3）循环链表要求头结点和尾节点建立前驱和后继之间的关系，最后建立这种关系
    *
    *
    * */
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
    }

    Node pre , head ;

    public Node treeToDoublyList(Node root) {
//    特殊情况处理：当根节点为空时，直接返回空
        if (root==null)return null;
//        对根节点进行递归中序遍历
        dfs(root);
//        将头节点的前驱设置为尾节点，将尾节点的后继设置为头结点
        head.left = pre ;
        pre.right = head ;
//        返回双向链表的头结点
        return head ;
    }


//    中序遍历递归实现方式
    public void dfs(Node cur){
//        如果但前节点为叶子节点，直接返回
        if (cur==null)return ;//cur为空时，pre指向链表的尾节点
//        递归中序遍历左子树
        dfs(cur.left);
//        处理根节点
//        如果前驱节点为空，将头结点设置为当前节点；如果前驱节点不为空，将前驱节点的右节点设置为当前节点；
        if (pre==null) head = cur ;
        else pre.right = cur;
//        双向链表，将后继节点的前驱节点设置为前驱节点
        cur.left = pre ;
//        当前节点成为下一次遍历的前驱节点
        pre = cur ;
//        递归中序遍历右子树
        dfs(cur.right);
    }









}
