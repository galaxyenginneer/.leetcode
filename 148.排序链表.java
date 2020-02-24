/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (62.50%)
 * Likes:    418
 * Dislikes: 0
 * Total Accepted:    41.8K
 * Total Submissions: 65.5K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 
 */
import java.util.*;
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
    public ListNode sortList(ListNode head) {
        if (head==null) return head;
        List<ListNode> res=new ArrayList<ListNode>();
        while (head!=null){
            res.add(head);
            head=head.next;
        }
        Collections.sort(res,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
            }
        });
        for (int i=1;i<res.size();i++){
            // ListNode p;
            res.get(i-1).next=res.get(i);
        }
        res.get(res.size()-1).next=null;
        return res.get(0);
    }
}
// @lc code=end

