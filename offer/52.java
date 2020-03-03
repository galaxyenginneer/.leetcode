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
import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int num=0;
        ListNode p=headA,q=headB;
        while(headA!=null) {
            num++;
            headA=headA.next;
        }
        while(headB!=null) {
            num--;
            headB=headB.next;
        }
        headA=p;headB=q;
        if (num>0){
            while(num-->0)headA=headA.next;
        }else {
            while(num++<0)headB=headB.next;
        }
        while(headA!=null && headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}