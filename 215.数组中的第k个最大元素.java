/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (59.32%)
 * Likes:    379
 * Dislikes: 0
 * Total Accepted:    83K
 * Total Submissions: 135.6K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    int[] nums;
    int len;
    void HeapSort(int ind){
        int temp=nums[ind];
        for (int k=ind*2+1;k<len;k=2*k+1){
            if (k+1<len && nums[k+1]>nums[k]) k++;
            if (nums[k]>temp){
                nums[ind]=nums[k];
                ind=k;
            }else break;
        }
        nums[ind]=temp;
    }
    int pop(){
        int temp=nums[0];
        nums[0]=nums[--len];
        HeapSort(0);
        return temp;
    }
    public int findKthLargest(int[] nums, int k) {
        this.nums=nums;
        len=nums.length;
        for (int i=(len+1)/2-1;i>-1;i--){
            HeapSort(i);
        }
        for(int i=0;i<k-1;i++){
            pop();
        }
        return pop();
    }
}
// @lc code=end

