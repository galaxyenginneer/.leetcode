import java.util.*;
class Solution {
    int res=0;
    int[] nums;
    int[] merge(int[]a, int[]b){
        int[] sum=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(k<sum.length){
            if (i==a.length){
                for(;j<b.length;j++,k++){
                    sum[k]=b[j];
                }
                break;
            }
            if (j==b.length){
                for(;i<a.length;i++,k++){
                    sum[k]=a[i];
                }
                break;
            }
            if (a[i]<=b[j]){
                sum[k]=a[i];
                i++;
            }else{
                sum[k]=b[j];
                j++;
                res+=a.length-i;
            }
            k++;
        }
        return sum;
    }
    int[] mergesort(int a,int b){
        if (a==b) return new  int[]{nums[a]};
        int mid=(a+b)/2;
        return merge(mergesort(a,mid),mergesort(mid+1, b));
    }
    public int reversePairs(int[] nums) {
        // int res=0;
        this.nums=nums;
        // list=new LinkedList<Integer>();
        if (nums.length==0) return 0;
        // list.add(nums[nums.length-1]);
        mergesort(0, nums.length-1);
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