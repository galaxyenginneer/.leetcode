/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 *
 * https://leetcode-cn.com/problems/count-of-range-sum/description/
 *
 * algorithms
 * Hard (31.52%)
 * Likes:    56
 * Dislikes: 0
 * Total Accepted:    2.2K
 * Total Submissions: 6.8K
 * Testcase Example:  '[-2,5,-1]\n-2\n2'
 *
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * 
 * 说明:
 * 最直观的算法复杂度是 O(n^2) ，请在此基础上优化你的算法。
 * 
 * 示例:
 * 
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3 
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res=0;
        int [][] sum=new int[nums.length][nums.length];
        for (int i=0;i<nums.length;i++){
            sum[i][i]=nums[i];
            int j=i;
            if (sum[i][j]>=lower&sum[i][j]<=upper) res++;
            for (j=i+1;j<nums.length;j++){
                sum[i][j]=sum[i][j-1]+nums[j];
                if (sum[i][j]>=lower&sum[i][j]<=upper) res++;
            }
        }
        return res;
    }
}
// @lc code=end

