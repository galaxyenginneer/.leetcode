/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 *
 * https://leetcode-cn.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (32.70%)
 * Likes:    96
 * Dislikes: 0
 * Total Accepted:    6.3K
 * Total Submissions: 18.9K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h)
 * 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 
 * 说明:
 * 不允许旋转信封。
 * 
 * 示例:
 * 
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3 
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] res;
    int[][] env;
    public int search(int i){
        if (res[i]>0) return res[i];
        int max=0;
        for (int j=0;j<env.length;j++){
            if (env[i][0]>env[j][0] & env[i][1]>env[j][1]){
                int t=search(j);
                if (t>max) max=t;
            }
        }
        res[i]=1+max;
        return res[i];
    }
    public int maxEnvelopes(int[][] envelopes) {
        // boolean[][] link=new boolean[envelopes.length][envelopes.length];
        // for (int i=0;i<envelopes.length;i++){
        //     for (int j=0;j<envelopes.length;j++){
        //         if (i==j)continue;
        //         if (envelopes[i][0]>envelopes[j][0] & envelopes[i][1]>envelopes[j][1])
        //         link[i][j]=true;
        //     }
        // }
        env=envelopes;
        res=new int[envelopes.length];
        int max=0;
        for (int i=0;i<envelopes.length;i++){
            int t=search(i);
            System.out.println(t);
            if (t>max) max=t;
        }
        return max;
    }
}
// @lc code=end

