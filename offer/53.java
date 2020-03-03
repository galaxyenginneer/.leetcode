class Solution {
    public int search(int[] nums, int target) {
        if (nums.length==0)return 0;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(right+left)>>1;
            int temp=nums[mid]-target;
            if (temp==0){
                int p=mid,res=0;
                while(p<nums.length && nums[p++]==target)res++;
                while(mid>0 && nums[--mid]==target)res++;
                return res;
            }
            if (temp<0) left=mid+1;
            else right=mid-1;
        }
        if (nums[left]==target)return 1;
        return 0;
    }
}