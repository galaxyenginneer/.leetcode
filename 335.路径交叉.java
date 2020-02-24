/*
 * @lc app=leetcode.cn id=335 lang=java
 *
 * [335] 路径交叉
 *
 * https://leetcode-cn.com/problems/self-crossing/description/
 *
 * algorithms
 * Hard (29.77%)
 * Likes:    16
 * Dislikes: 0
 * Total Accepted:    891
 * Total Submissions: 2.9K
 * Testcase Example:  '[2,1,1,2]'
 *
 * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动
 * x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * 
 * 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
 * 
 * 
 * 
 * 示例 1:
 * 
 * ┌───┐
 * │   │
 * └───┼──>
 * │
 * 
 * 输入: [2,1,1,2]
 * 输出: true 
 * 
 * 
 * 示例 2:
 * 
 * ┌──────┐
 * │      │
 * │
 * │
 * └────────────>
 * 
 * 输入: [1,2,3,4]
 * 输出: false 
 * 
 * 
 * 示例 3:
 * 
 * ┌───┐
 * │   │
 * └───┼>
 * 
 * 输入: [1,1,1,1]
 * 输出: true 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isSelfCrossing(int[] x) {
        int dx,dy;
        dx=x[0]-x[2];
        dy=x[1]-x[3];
        if (dx==0 | dy==0) return true;
        if (dx>0 & dy<0) return true;
        return false;
    }
}
// @lc code=end

