/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-06 14:58
 **/
public class JianZhi_52二刷 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA=headA;
            ListNode curB=headB;
            while(curA!=curB){
                curA=curA!=null?curA.next:headB;
                curB=curB!=null?curB.next:headA;
            }
            return curA;
        }
    }
}
