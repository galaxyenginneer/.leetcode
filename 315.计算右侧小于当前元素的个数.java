import java.util.List;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 *
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (37.50%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    10.2K
 * Total Submissions: 27.3K
 * Testcase Example:  '[5,2,6,1]'
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
 * nums[i] 的元素的数量。
 * 
 * 示例:
 * 
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0] 
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // List<Integer> res=Arrays.stream(new int[nums.length]).boxed().collect(Collectors.toList());
        int[] res=new int[nums.length];
        if (nums.length<=1){
            return Arrays.stream(res).boxed().collect(Collectors.toList());
        }
        for(int i=nums.length-2;i>-1;i--){
            for(int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[i]){
                    res[i]++;
                    if(nums.length-j-1==res[j]){
                        res[i]+=res[j];
                        break;
                    }
                }else if (nums[j]==nums[i]){
                    res[i]+=res[j];
                    break;
                }
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
// @lc code=end

