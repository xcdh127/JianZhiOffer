/**
 * @program: LeetCodeJavaTest
 * @description: 22
 * @author: Mr.Sun
 * @create: 2021-08-04 13:22
 **/
public class JianZhi_22二刷 {

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
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode formmer = head ;
            ListNode latter = head ;
            while(k>0){
                formmer=formmer.next;
                k--;
            }
            while(formmer!=null){
                formmer=formmer.next;
                latter=latter.next;
            }
            return latter ;
        }
    }
}
