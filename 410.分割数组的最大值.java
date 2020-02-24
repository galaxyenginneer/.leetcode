/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 *
 * https://leetcode-cn.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (39.61%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    4.2K
 * Total Submissions: 10.4K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 
 * 注意:
 * 数组长度 n 满足以下条件:
 * 
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * 
 * 示例: 
 * 
 * 
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * 输出:
 * 18
 * 
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    int [][] f;
    public int sum(int[] nums,int i,int j){
        int sum=0;
        for (int k=i;k<=j;k++){
            sum+=nums[k];
        }
        return sum;
    }
    public int splitArray(int[] nums, int m) {
        f=new int[nums.length][m+1];
        f[0][1]=nums[0];
        for(int j=1;j<nums.length;j++) f[j][1]=f[j-1][1]+nums[j];
        for(int i=2;i<=m;i++){
            int j=i==m?nums.length-1:i-1;
            for(;j<=nums.length-m-1+i;j++){
                int min=Integer.MAX_VALUE;
                int tmp=0;
                for (int k=j-1;k>=i-2;k--){
                    tmp+=nums[k+1];
                    if (tmp>=min)break;
                    // tmp=Math.max(tmp,f[k][m-1]);
                    
                    // System.out.println(f[k][i-1]+" "+tmp);
                    min=Math.min(Math.max(tmp,f[k][i-1]), min);
                    // System.out.println(min);
                }
                System.out.println(j+" "+i+" "+min);
                f[j][i]=min;
            }
        }
        return f[nums.length-1][m];

    }
}
// @lc code=end

