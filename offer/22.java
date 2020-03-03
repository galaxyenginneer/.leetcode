/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p=head,q=head;
        for (int i=0;i<k-1;i++) q=q.next;
        while(q.next!=null){
            p=p.next;
            q=q.next;
        }
        return p;
    }
}