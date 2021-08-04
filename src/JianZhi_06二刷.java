import java.util.Stack;

/**
 * @program: LeetCodeJavaTest
 * @description: 06
 * @author: Mr.Sun
 * @create: 2021-08-04 13:19
 **/
public class JianZhi_06二刷 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode cur = head ;
            Stack<Integer> stack = new Stack<Integer>();
            while(cur!=null){
                stack.push(cur.val);
                cur=cur.next;
            }
            int size = stack.size();
            int[] res = new int[size];
            for(int i=0;i<size;i++){
                res[i]=stack.pop();
            }
            return res ;
        }
    }
}
