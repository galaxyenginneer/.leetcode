/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (35.24%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 45.9K
 * Testcase Example:  '[1,2,0]'
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int s=1;
        int i;
        if (nums.length==0) return 1;
        for (i = 0; i < nums.length-1; i++) {
            if (nums[i]>0){                
                break;
            }
        } 
        if (nums[i]<=0|nums[i]>1) return 1;
        for (;i < nums.length-1; i++){
            if (nums[i+1]-nums[i]>1) 
                return nums[i] + 1;;
        }
        return nums[nums.length-1]+1;

    }
}

