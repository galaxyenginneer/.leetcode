import java.util.*;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (48.06%)
 * Likes:    224
 * Dislikes: 0
 * Total Accepted:    17.7K
 * Total Submissions: 35.3K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        if(n<2) return n;
        int max=Integer.MAX_VALUE;
        // int [] nums=new int[3];
        // boolean [] dp=new boolean[max+1];
        List<Integer> res=new ArrayList<>();
        // dp[1]=true;
        // List<Integer> nums=new ArrayList<>();
        int a=1,b,c;
        while(true){
            b=a;
            while (true){
                c=b;
                while (true){
                    res.add(c);
                    if (c>max/2)break;
                    c*=2;
                }
                if (b>max/3)break;
                b*=3;
            }
            System.out.println(res.size());
            if (a>max/5)break;
            a*=5;
        }
        Collections.sort(res);
        return res.get(n-1);
    }
}
// @lc code=end

