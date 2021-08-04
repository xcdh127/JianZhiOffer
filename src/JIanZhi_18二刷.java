/**
 * @program: LeetCodeJavaTest
 * @description: 18
 * @author: Mr.Sun
 * @create: 2021-08-04 13:20
 **/
public class JIanZhi_18二刷 {

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
        public ListNode deleteNode(ListNode head, int val) {
            if(head.val==val){
                head=head.next;
            }
            ListNode cur =head;
            while(cur!=null){
                if(cur.next!=null&&cur.next.val==val){
                    cur.next=cur.next.next;
                }
                cur=cur.next;
            }
            return head;
        }
    }
}
