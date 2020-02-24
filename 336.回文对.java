import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 *
 * https://leetcode-cn.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (31.32%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    2.6K
 * Total Submissions: 7.9K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * 
 * 示例 1:
 * 
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]] 
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]] 
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * 
 */

// @lc code=start
class Solution {
    public boolean check(String a, String b){
        String s=a+b;
        int n=s.length()/2;
        for (int i=0;i<n;i++){
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for (int i=0;i<words.length;i++){
            for (int j=0;j<words.length;j++){
                if (i==j) continue;
                if (check(words[i],words[j])){
                    List<Integer> t=new ArrayList<Integer>();
                    t.add(i);
                    t.add(j);
                    res.add(t);
                }
            }
        }
        return res;
    }
}
// @lc code=end

