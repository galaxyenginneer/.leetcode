class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum ^= nums[i];
        }
        int flag=(-sum)&sum;
        int []res=new int[2];
        for (int i=0;i<nums.length;i++){
            if ((nums[i] ^ flag) ==0){
                res[0]^=nums[i];
            }else{
                res[1]^=nums[i];
            }
        }
        return res;
    }
}