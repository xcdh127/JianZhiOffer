import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCodeJavaTest
 * @description: 剑指offer第6题
 * @author: Mr.Sun
 * @create: 2021-05-27 13:46
 **/
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
/*
 *输入：head = [1,3,2]
 *输出：[2,3,1]
*/
public class JianZhi_06 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) { val = x; }
    }

    public static int[] reversePrint(ListNode head) {
        Stack stack = new Stack();
        ListNode cur = head;
        while(cur!=null){

            stack.push(cur);
            cur = cur.next;

        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
//           arr[i] = stack.pop().val;
        }


        return arr;
    }
    public static void main(String[] args) {
//     reversePrint(new ListNode(2,new ListNode(2,new ListNode())));

    }



}
