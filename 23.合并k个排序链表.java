/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode merge(ListNode a,ListNode b){
        ListNode s,p;
        p=new ListNode(0);
        s=p;
        while(true){
            if (a==null) {
                p.next = b;
                return s.next;
            }else if (b==null){
                p.next = a;
                return s.next;
            }
            if (a.val>b.val){
                p.next=b;
                b=b.next;
            }else {
                p.next=a;
                a=a.next;
            }
            p=p.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode s;
        if (lists.length==0)return null;
        s=lists[0];
        for (int i=1;i<lists.length;i++){
            s=merge(s,lists[i]);
        }
        return s;
    }
}

