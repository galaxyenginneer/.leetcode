/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (43.87%)
 * Likes:    471
 * Dislikes: 0
 * Total Accepted:    18.6K
 * Total Submissions: 41.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
class Solution {
    public int trap(int[] height) {
        int from,now,sum=0,part,i=0,index=0;
        if (height.length==0)return 0;
        for (i=0;i<height.length;i++){
            if (height[i]>0) break;
        }
        if (i==height.length) return 0;
        
        while(i<height.length){
            part=0;
            now = height[i];
            index=i;
            i++;
            for(;i<height.length;i++){
                if (height[i] >= now) break;
                part += now - height[i];
                
            }
            if (i== height.length) break;
            sum+=part;
            System.out.println(part);
        }
        i=height.length-1;
        while(i>=index){
            part = 0;
            now = height[i];
            i--;
            for (;i >= index ;i--){
                if (height[i] >= now)
                    break;
                part += now - height[i];

            }
            System.out.println(part);
            sum += part;
        }
        return sum;
    }
}

