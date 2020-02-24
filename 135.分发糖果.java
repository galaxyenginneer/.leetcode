/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int [] w= new int[ratings.length];
        for (int i=0;i<ratings.length;i++){
            int p=Integer.MAX_VALUE,q=Integer.MAX_VALUE;
            if (i!=0) p=ratings[i-1];
            if (i!=ratings.length-1) q=ratings[i+1];
            if (p>=ratings[i]&ratings[i]<=q) {
                w[i]=1;
                for(int j=i-1;j>-1;j--){
                    if (ratings[j]>ratings[j+1]) w[j]=Integer.max(w[j],w[j+1]+1);
                    else break;
                }
                for(int j=i+1;j<ratings.length;j++){
                    if (ratings[j]>ratings[j-1]) w[j]=Integer.max(w[j],w[j-1]+1);
                    else break;
                }
            }
        }
        System.out.println(Arrays.toString(w));
        int sum=0;
        for (int i=0;i<ratings.length;i++){
            sum+=w[i];
        }
        return sum;
    }
}
// @lc code=end

