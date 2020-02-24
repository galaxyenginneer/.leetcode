/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 *
 * https://leetcode-cn.com/problems/number-of-digit-one/description/
 *
 * algorithms
 * Hard (31.26%)
 * Likes:    93
 * Dislikes: 0
 * Total Accepted:    4.9K
 * Total Submissions: 15K
 * Testcase Example:  '13'
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 * 示例:
 * 
 * 输入: 13
 * 输出: 6 
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * 
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        if (n<=0) return 0;
        String s=Integer.toString(n);
        int num=1,sum=0;
        for (int i =s.length()-1;i>-1;i--){
            int a=i>0?Integer.parseInt(s.substring(0, i)):0;
            int b=Integer.parseInt(""+s.charAt(i));
            sum+=a*num;
            if (b>1){
                sum+=num;
            }
            if (b==1){
                sum+=i+1<s.length()?Integer.parseInt(s.substring(i+1))+1:1;
            }
            System.out.println(sum);
            num*=10;
        }
        // int b=Integer.parseInt(""+s.charAt(0));
        // if (b>1){
        //     sum+=num;
        // }
        return sum;
    }
    
}
// @lc code=end

