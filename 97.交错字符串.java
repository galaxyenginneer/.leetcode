/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (37.05%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    6.3K
 * Total Submissions: 17.2K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isRight(String s2, String s3) {
        for (int t = 0; t < s3.length(); t++) {
            if (s2.charAt(t) != s3.charAt(t))
                return false;
            // System.out.print(s3.charAt(t));
        }
        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int i, j = 0, k = 0, t, t1, t2;
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s1.length() == 0) {
            return isRight(s2, s3);
        }
        if (s2.length() == 0) {
            return isRight(s1, s3);
        }
        for (i = 0; i < s3.length(); i++) {
            // if(i==12){
            //     System.out.print("" + (i + 1) + j + k);
            //     System.out.print("" + s3.charAt(i)+s1.charAt(j)+s2.charAt(k));
            // }
            if (j == s1.length())
                return isRight(s2.substring(k), s3.substring(i));
            if (k == s2.length())
                return isRight(s1.substring(j), s3.substring(i));
            if (s3.charAt(i) == s1.charAt(j)) {
                if (s3.charAt(i) == s2.charAt(k)) {
                    // if (isInterleave(s1.substring(j+1), s2.substring(k), s3.substring(i+1)))
                    // return true;
                    // else if (isInterleave(s1.substring(j), s2.substring(k+1), s3.substring(i+1)))
                    // return true;
                    // return false;
                    if (s3.charAt(i + 1) == s3.charAt(i)) {
                        j++;
                        k++;
                        i++;
                        System.out.print(s3.charAt(i));
                        System.out.print(s3.charAt(i));
                        continue;
                    } 
                    for (t = i + 1; t < s3.length(); t++) {
                        t1 = s1.indexOf(s3.charAt(t), j + t - i) - j;
                        t2 = s2.indexOf(s3.charAt(t), k + t - i) - k;
                        if (t1 < 0)
                            t1 = s3.length();
                        if (t2 < 0)
                            t2 = s3.length();
                        // System.out.print(""+t1+" "+t2);
                        if (t1 == t2)
                            continue;
                        if (t1 < t2)
                            j++;
                        else
                            k++;
                    }
                } else
                    j++;
            } else if (s3.charAt(i) == s2.charAt(k))
                k++;
            else
                return false;
            System.out.print(s3.charAt(i));
            System.out.print("" + (i + 1) + j + k);
        }
        return true;
    }
}
// @lc code=end
