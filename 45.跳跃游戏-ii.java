/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (30.11%)
 * Likes:    215
 * Dislikes: 0
 * Total Accepted:    11.7K
 * Total Submissions: 37.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */
class Solution {

    public int jump(int[] nums) {
        int[] w= new int[nums.length];
        for(int i=0;i<nums.length;i++) w[i]=nums.length*10+1;
        w[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j< nums.length&j<=i+nums[i];j++){
                w[j]=Math.min(w[j],w[i]+1);
            }
        } 
        return w[nums.length-1];
    }
}

