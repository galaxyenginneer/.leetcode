import java.util.*;
class Solution {
    // List<Integer> list;
    Node head=new Node(Integer.MIN_VALUE);
    // Node tail=head;
    // int num=1;
    int incert(int val){
        int i=0;
        Node p=head;
        for (;p.next!=null;i++){
            if(p.next.val>val)break;
            p=p.next;
        }
        p.next=new Node(val);
        return i;
    }
    public int reversePairs(int[] nums) {
        int res=0;
        // list=new LinkedList<Integer>();
        if (nums.length==0) return 0;
        // list.add(nums[nums.length-1]);
        for (int i=nums.length-2;i>-1;i--){
            res+=incert(nums[i]);
        }
        return res;
    }
    class Node{
        int val;
        // Node pre;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
}