/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 *
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (38.52%)
 * Likes:    119
 * Dislikes: 0
 * Total Accepted:    9K
 * Total Submissions: 22.6K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 
 * 示例 1:
 * 
 * 输入: nums = 
 * [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ] 
 * 输出: 4 
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 
 * 示例 2:
 * 
 * 输入: nums = 
 * [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ] 
 * 输出: 4 
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 
 * 
 */

// @lc code=start
class Solution {
    // int res=0;
    boolean[][] ind;
    int[][] mat;
    int[][] res;
    public int search(int i,int j,int last,int sum){
        if (i<0 | i>=mat.length) return sum;
        if (j<0 | j>=mat[0].length) return sum;
        if (ind[i][j]) return sum;
        if (mat[i][j]<=last) return sum;
        if (res[i][j]>0) return sum+res[i][j];
        sum++;
        ind[i][j]=true;
        int now=sum,tmp;
        tmp=search(i-1, j, mat[i][j], sum);
        if (tmp>now) now=tmp;
        tmp=search(i+1, j, mat[i][j], sum);
        if (tmp>now) now=tmp;
        tmp=search(i, j+1, mat[i][j], sum);
        if (tmp>now) now=tmp;
        tmp=search(i, j-1, mat[i][j], sum);
        if (tmp>now) now=tmp;
        ind[i][j]=false;
        res[i][j]=now-sum+1;
        return now;
    }
    public int longestIncreasingPath(int[][] matrix) {
        mat=matrix;
        if (mat.length==0) return 0;
        res=new int[mat.length][mat[0].length];
        int result=0;
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                ind=new boolean[mat.length][mat[0].length];
                search(i,j,Integer.MIN_VALUE,0);
                if (res[i][j]>result) result=res[i][j];
            }
        }
        return result;
    }
}
// @lc code=end

