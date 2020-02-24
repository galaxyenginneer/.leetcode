import java.util.List;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (25.64%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 12.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord))
            return result;
        wordList.add(0, beginWord);
        int[][] w = new int[wordList.size()][wordList.size()];
        boolean[] book = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size() - 1; i++){
            for (int j = i + 1; j < wordList.size(); j++) {
                if (compare(wordList.get(i), wordList.get(j)))
                    w[j][i] = w[i][j] = 1;
                else
                    w[j][i] = w[i][j] = wordList.size();
            }
        }
        w[0][0] = wordList.size();
        int min = 0;
        // System.out.println(Arrays.toString(w[0]));
        for (int k = 1; k < wordList.size(); k++) {
            min=0;
            for (int i = 1; i < wordList.size(); i++) {
                if (book[i])
                    continue;
                if (w[0][min] > w[0][i])
                    min = i;
            }
            book[min]=true;
            // System.out.println(Arrays.toString(w[0]));
            if(min==0) continue;
            for (int i = 1; i < wordList.size(); i++) {
                if (book[i] | i == min)
                    continue;
                if (w[0][i] > w[0][min] + w[min][i])
                    w[0][i] = w[0][min] + w[min][i];
            }
        }
        int end = wordList.indexOf(endWord);
        int start = 0;
        int num = w[0][end];
        w[0][0] = 0;
        List<Integer> now = new LinkedList<>();
        now.add(end);     
        trace(w, now, num,wordList,result);
        return result;
    }
    
    private Boolean compare(String a, String b) {
        if (a.length() != b.length())
            return false;
        int sum = 0;
        for (int i = 0; i < a.length() && sum < 2; i++) {
            if (a.charAt(i) != b.charAt(i))
                sum++;
        }
        if (sum == 1)
            return true;
        return false;
    }

    private void trace(int[][] w, List<Integer> now, int num, List<String> wordList, List<List<String>> result) {
        int len = now.size();
        // System.out.println(""+len+" "+num);
        if (len == num+1) {
            System.out.println(Arrays.toString(now.toArray()));
            List<String> t = new LinkedList<>();
            for (int i = now.size() - 1; i >= 0; i--) {
                // System.out.println(i);
                t.add(wordList.get(now.get(i)));
            }
            result.add(t);
            return;
        }
        for (int i = 0; i < w.length; i++) {
            if (len + w[0][i] != num)
                continue;
            if (w[now.get(now.size()-1)][i] == 1) {
                List<Integer> tmp = new LinkedList<>(now);
                // Collections.copy(tmp, now);
                // System.out.println(i);
                tmp.add(i);
                trace(w, tmp, num, wordList, result);
            }
        }
        return;
    }

}

// @lc code=end
