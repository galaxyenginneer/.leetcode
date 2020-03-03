class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0)return 0;
        // int[] sum=new int[nums.length];
        int last=0,res=nums[0];
        for (int i=0;i<nums.length;i++){
            last=last>0?last+nums[i]:nums[i];
            res=Math.max(last,res);
        }
        return res;
    }
}