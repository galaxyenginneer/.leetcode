/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (43.30%)
 * Likes:    103
 * Dislikes: 0
 * Total Accepted:    7.5K
 * Total Submissions: 17.4K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);
        // if (nums.length == 2)
        //     if (nums[1]==nums[0])return 1;
        int max = 0, now = 1;
        System.out.println(Arrays.toString(nums));

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1 ) {
                now++;
            } else if(nums[i] !=nums[i - 1]){
                if (now > max)
                    max = now;
                now = 1;
            }
        }
        if (now > max)
            max = now;
        return max;
    }
}
// @lc code=end
