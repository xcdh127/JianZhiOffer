/**
 * @program: LeetCodeJavaTest
 * @description:
 * @author: Mr.Sun
 * @create: 2021-08-05 19:48
 **/
public class JianZhi_24二刷 {
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
        public ListNode reverseList(ListNode head) {
            return recur(head,null);
        }

        public ListNode recur(ListNode cur,ListNode pre){
            if(cur==null){
                return pre;
            }
            ListNode res = recur(cur.next,cur);
            cur.next=pre;
            return res ;
        }
    }

}
