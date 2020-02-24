import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 *
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/description/
 *
 * algorithms
 * Hard (32.28%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 5.4K
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 
 * 
 * 
 * 说明:
 * 
 * m 和 n 都是小于110的整数。每一个单位的高度都大于 0 且小于 20000。
 * 
 * 
 * 
 * 示例：
 * 
 * 给出如下 3x6 的高度图:
 * [
 * ⁠ [1,4,3,1,3,2],
 * ⁠ [3,2,1,3,2,4],
 * ⁠ [2,3,3,2,3,1]
 * ]
 * 
 * 返回 4。
 * 
 * 
 * 
 * 
 * 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 * 
 * 
 * 
 * 
 * 
 * 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 * 
 */

// @lc code=start
class Solution {
    boolean[][] able;
    int[][] map;
    public boolean isborder(int i,int j){
        if (i<0 | j<0) return true;
        if (i>=map.length | j>=map[0].length) return true;
        return false;
    }
    public int trapRainWater(int[][] heightMap) {
        able=new boolean[heightMap.length][heightMap[0].length];
        List<int[]> now=new ArrayList<int []>();
        map=heightMap;
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++)
                if (isborder(i, j)){
                    if (able[i][j]) continue;
                    able[0][i]=true;
                    now.add(new int[]{0,i});
                }
        }
    }
}
// @lc code=end

