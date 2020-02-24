/*
 * @lc app=leetcode.cn id=391 lang=java
 *
 * [391] 完美矩形
 *
 * https://leetcode-cn.com/problems/perfect-rectangle/description/
 *
 * algorithms
 * Hard (22.52%)
 * Likes:    35
 * Dislikes: 0
 * Total Accepted:    974
 * Total Submissions: 4K
 * Testcase Example:  '[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]'
 *
 * 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 * 
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1)
 * 以及右上角的点的坐标为 (2, 2) )。
 * 
 * 
 * 
 * 示例 1:
 * 
 * rectangles = [
 * ⁠ [1,1,3,3],
 * ⁠ [3,1,4,2],
 * ⁠ [3,2,4,4],
 * ⁠ [1,3,2,4],
 * ⁠ [2,3,3,4]
 * ]
 * 
 * 返回 true。5个矩形一起可以精确地覆盖一个矩形区域。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 2:
 * 
 * rectangles = [
 * ⁠ [1,1,2,3],
 * ⁠ [1,3,2,4],
 * ⁠ [3,1,4,2],
 * ⁠ [3,2,4,4]
 * ]
 * 
 * 返回 false。两个矩形之间有间隔，无法覆盖成一个矩形。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 3:
 * 
 * rectangles = [
 * ⁠ [1,1,3,3],
 * ⁠ [3,1,4,2],
 * ⁠ [1,3,2,4],
 * ⁠ [3,2,4,4]
 * ]
 * 
 * 返回 false。图形顶端留有间隔，无法覆盖成一个矩形。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 4:
 * 
 * rectangles = [
 * ⁠ [1,1,3,3],
 * ⁠ [3,1,4,2],
 * ⁠ [1,3,2,4],
 * ⁠ [2,2,4,4]
 * ]
 * 
 * 返回 false。因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean iscover(int[][] rectangles,int i,int j){
        if (rectangles[i][0]>=rectangles[j][2] | rectangles[i][2]<=rectangles[j][0]) return false;
        if (rectangles[i][1]>=rectangles[j][3] | rectangles[i][3]<=rectangles[j][1]) return false;
        return true;
    }
    public boolean isRectangleCover(int[][] rectangles){
        if (rectangles.length==0) return false;
        int area=0,i=0;
        int[] target=new int[4];
        for (i=0;i<4;i++) target[i]=rectangles[0][i];
        for (i=0;i<rectangles.length;i++){
            // System.out.println(i);
            area+=(rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
            for (int j=0;j<i;j++){
                if (iscover(rectangles, i, j)) return false;
            }
            for (int j=0;j<2;j++) target[j]=Math.min(rectangles[i][j],target[j]);
            for (int j=2;j<4;j++) target[j]=Math.max(rectangles[i][j],target[j]);
        }
        if (area==(target[2]-target[0])*(target[3]-target[1])) return true;
        return false;
    }
}
// @lc code=end

