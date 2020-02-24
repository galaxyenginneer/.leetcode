import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (26.76%)
 * Likes:    253
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 46.7K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        int p=s.indexOf('(');
        // System.out.println(p);
        int sum=0,now=0;
        if (p==-1||p==s.length()-1){
            return 0;
        }
        int tmp=1;
        int[] w=new int [s.length()];
        Stack<Integer> left=new Stack<Integer>();
        for (int i=p;i<s.length();i++){
            if (s.charAt(i)=='(') {
                left.push(i);                
            }
            else{
                if (left.isEmpty()) {
                    // sum = 0;
                    continue;
                }
                tmp=left.pop();
                if (tmp!=0)w[i]=w[tmp-1]+i-tmp+1;
                else 
                    w[i] = i - tmp + 1;
            }
        }
        return  Arrays.stream(w).max().getAsInt();

    }
}

