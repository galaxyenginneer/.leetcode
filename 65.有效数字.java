/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 *
 * https://leetcode-cn.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (14.59%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    5.5K
 * Total Submissions: 33.4K
 * Testcase Example:  '"0"'
 *
 * 验证给定的字符串是否可以解释为十进制数字。
 * 
 * 例如:
 * 
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * 
 * 
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 
 * 
 * 当然，在输入中，这些字符的上下文也很重要。
 * 
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * 
 */
class Solution {
    public boolean isNumber(String s) {
        int i=0,j=0;
        // System.out.println("" + i + ' ' + j);
        for (i=0;i<s.length();i++){
            if (s.charAt(i)==' ') continue;
            else break;
        }
        for (j = s.length()-1;j>=0 ; j--) {
            // System.out.println(j);
            if (s.charAt(j) == ' ')
                continue;
            else
                break;
        }
        System.out.println("" + i + ' ' + j);
        if (j<i) return false;
        s=s.substring(i, j+1);
        System.out.println(s);
        i=0;
        // if (s.charAt(i)=='-' | s.charAt(i)=='+' | s.charAt(i) == '.') i++;

        // if (s.charAt(i)>'9' | s.charAt(i)<'0') return false;
        int e=s.indexOf('e');
        System.out.println(e);

        try {
            if (e==-1){
                Double.parseDouble(s);
            }else{
                if (e== s.length() - 1| e==0) return false;
                Double.parseDouble(s.substring(0, e-1));
                j=Integer.parseInt(s.substring(e+1,s.length()));
                // if (j==0) return false;
            }
            // all number are good.
        } catch (NumberFormatException w) {
            return false;
        }
        return true;
        
    }
}

