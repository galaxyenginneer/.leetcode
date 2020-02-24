/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    int cal(int[][] points,int i,int j){
        int sum=2;
        if (Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1])==0){
            for (int k=j+1;k<points.length;k++){
                if (Math.abs(points[k][0]-points[i][0])+Math.abs(points[k][1]-points[i][1])==0){
                    sum+=1;
                }
            }
            return sum;
        }
        for (int k=0;k<points.length;k++){
            if (k==i | k==j) continue;
            long a=((long)(points[k][0]-points[i][0]))*(long)(points[k][1]-points[j][1]);
            long b=((long)(points[k][0]-points[j][0]))*(long)(points[k][1]-points[i][1]);
            // int a=(points[k][0]-points[i][0])*(points[k][1]-points[j][1]);
            // int b=(points[k][0]-points[j][0])*(points[k][1]-points[i][1]);
            // System.out.println(a);
            // System.out.println(b);
            if (a==b) sum+=1;
        }
        return sum;
    }
    public int maxPoints(int[][] points) {
        int sum=2;
        int nums=points.length;
        if (nums<2) return nums;
        for(int i=0;i<nums-1;i++){
            for (int j=i+1;j<nums;j++){
                int now=cal(points,i,j);
                if (now>sum){
                    sum=now;
                }
            }
        }
        return sum;
    }
}
// @lc code=end

