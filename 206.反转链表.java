import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (65.55%)
 * Likes:    785
 * Dislikes: 0
 * Total Accepted:    166.2K
 * Total Submissions: 246.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null)return null;
        List<ListNode>res=new ArrayList<>();
        ListNode p=head;
        while(p!=null){
            res.add(p);
            p=p.next;
        }
        for (int i=0;i<res.size();i++){
            res.get(i).next=i==0?null:res.get(i-1);
        }
        return res.get(res.size()-1);
    }
}
// @lc code=end

