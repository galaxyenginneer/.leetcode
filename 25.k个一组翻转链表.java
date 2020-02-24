import java.util.Queue;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] k个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (51.35%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    13.3K
 * Total Submissions: 25.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> st= new Stack<ListNode>();
        ListNode q=head;
        ListNode dummy = new ListNode(0);
        ListNode p=dummy;
        while (q!=null){
            ListNode tmp=q;
            for (int i=0;i<k;i++){
                if (q==null){
                    p.next=tmp;
                    return dummy.next;
                }
                st.push(q);
                q = q.next;
                // System.out.println(i);
            }

            while(!st.empty()){
                p.next=st.pop();
                p=p.next;
            }
            p.next=null;
            if(q==null){
                return dummy.next;
            }
        }
        System.out.println(1);
        return dummy.next;
        
    }
}
// [1,2]\n2
