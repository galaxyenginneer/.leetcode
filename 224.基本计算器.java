import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (35.88%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    9.3K
 * Total Submissions: 25.4K
 * Testcase Example:  '"1 + 1"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 
 * 示例 1:
 * 
 * 输入: "1 + 1"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 
 * 示例 3:
 * 
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 
 * 说明：
 * 
 * 
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String cal(String s){
        System.out.println(s);
        int right=s.indexOf(')');
        if (right==-1) {
            int sum=0;
            int p=s.length();
            for (int i=s.length()-1;i>-1;i--){
                if (s.charAt(i)=='-'){
                    int code=0,j=i;
                    while(s.charAt(i)=='-'|s.charAt(i)=='+'){
                        if (s.charAt(i)=='-') code++;
                        i--;
                        if (i==-1) break;
                    }
                    code=code%2==1?-1:1;
                    sum+=Integer.parseInt(s.substring(j+1, p))*code;
                    i++;
                    p=i;
                    // System.out.println(sum);
                    continue;
                }
                if (s.charAt(i)=='+'){
                    sum+=Integer.parseInt(s.substring(i+1, p));
                    p=i;
                    // System.out.println(sum);
                    continue;
                }
            }
            if (p>0)
                sum+=Integer.parseInt(s.substring(0, p));
            return Integer.toString(sum);
        }
        int left=s.lastIndexOf('(',right);
        s=s.substring(0, left)+cal(s.substring(left+1,right))+s.substring(right+1);
        return cal(s);
    }
    public int calculate(String s) {
        s=s.replaceAll(" ", "");
        s=cal(s);
        return Integer.parseInt(s);
    }
}
// @lc code=end

