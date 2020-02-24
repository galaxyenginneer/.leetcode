/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (34.33%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 19K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l;
        for (int i=0;i<intervals.length;i++){
            if (intervals[i][0]<=newInterval[0]&&newInterval[0]<=intervals[i][1]){
                intervals[i][1]=Math.max(intervals[i][1],newInterval[1]);
                int j=0;
                for (j=i+1;j<intervals.length;j++){
                    if (intervals[j][0]>intervals[i][1]) break;
                }
                l=Arrays.asList(intervals);
                j--;
                for(;j>i;j--){
                    l.remove(j);
                }
                return l.toArray();
                break;
            }
        }
    }
}
// @lc code=end

