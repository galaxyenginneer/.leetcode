import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 *
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (44.17%)
 * Likes:    100
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 12.3K
 * Testcase Example:  '"()())()"'
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * 
 * 示例 1:
 * 
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 
 * 
 * 示例 3:
 * 
 * 输入: ")("
 * 输出: [""]
 * 
 */

// @lc code=start
class Solution {
    public boolean check(String s){
        int left=0,right=s.length(),p=0;
        while(true){
            right=s.indexOf(")",p);
            if (right==-1){
                
            }
            left=s.lastIndexOf("(", left);
            if (left==-1) return false;
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<Integer> ind=new ArrayList<Integer>();
        for (int i=0;i<s.length();i++) ind.add(i);
        char p='0';
        for (int i=0;i<ind.size();i++){
            char c=s.charAt(ind.get(i));
            if (c!='(' & c!=')'){
                ind.remove(i);
                i--;
            }
            if (c==')'&p=='('){
                ind.remove(i-1);
                ind.remove(i-1);
                i-=2;
                c=i>-1?s.charAt(ind.get(i)):'0';
            }
            p=c;
        }

    }
}
// @lc code=end

