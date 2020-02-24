/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (37.79%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 12.3K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回符合要求的最少分割次数。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int num = s.length();
        int[] w = new int[s.length()];
        Stack<Integer> left = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (left.isEmpty()) {
                left.push(i);
                continue;
            }
            int tmp = left.peek();
            if (s.charAt(tmp) != s.charAt(i)) {
                if (tmp == i - 1 & i > 1) {
                    if (s.charAt(i - 2) == s.charAt(i)) {
                        tmp = left.pop();
                        if (left.isEmpty()) {
                            left.push(i);
                            continue;
                        }
                        tmp = left.pop();
                        w[i] = tmp - i;
                        w[tmp] = i - tmp;
                    }
                } else
                    left.push(i);

            } else {
                tmp = left.pop();
                // if (tmp != 0)
                // w[i] = w[tmp - 1] + i - tmp + 1;
                // else
                // w[i] = i - tmp + 1;
                w[i] = tmp - i;
                w[tmp] = i - tmp;
            }
        }
        int sum = 0;
        for (int i = 0; i < num - 1; i++) {
            if (w[i] <= 0 & w[i + 1] >= 0)
                sum++;
        }
        System.out.println(Arrays.toString(w));
        return sum;
    }
}
// @lc code=end
