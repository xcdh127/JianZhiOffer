/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-05 19:48
 **/
public class JianZhi_25二刷 {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode c1=l1;
            ListNode c2=l2;
            ListNode head=new ListNode(0);
            ListNode h1=head;
            while(c1!=null && c2!=null){
                if(c1.val<=c2.val){
                    h1.next=c1;
                    c1=c1.next;
                }
                else{
                    h1.next=c2;
                    c2=c2.next;
                }
                h1=h1.next;
            }
            h1.next=c1!=null? c1:c2;
            return head.next;
        }

    }





}
