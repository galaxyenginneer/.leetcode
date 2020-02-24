/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (37.07%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    9.1K
 * Total Submissions: 23.4K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 
 */
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

// @lc code=start
class Trie {
    ArrayList<Trie> sonList=new ArrayList<Trie>();
    // int[] pos=new int[26];
    // int num
    char val;
    Boolean isnode=false;
    int ind;
    /** Initialize your data structure here. */
    public Trie() {    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word,int index) {
        Boolean find=false;
        Trie next=new Trie();;
        if (word.length()==0) {
            isnode=true;
            ind=index;
            return;
        }
        for (Trie p:sonList){
            if (p.val==word.charAt(0)) {
                find=true;
                next=p;
                break;
            }
        }
        if (!find){
            next.val=word.charAt(0);
            sonList.add(next);
        }
        next.insert(word.substring(1),index);
        return;
    }
    
    /** Returns if the word is in the trie. */
    public Trie search(char word) {
        Boolean find=false;
        int next=0;
        for (Trie p:sonList){
            if (p.val==word) {
                find=true;
                break;
            }
            next++;
        }
        if (!find){
            return null;
        }
        return sonList.get(next);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */

}

class Solution {
    
    boolean nums[];
    boolean [][] run;
    public void search(Trie p,char[][] board,int i,int j){
        if (i>=board.length) return;
        if (j>=board[0].length) return;
        if (i<0) return;
        if (j<0) return;
        if (run[i][j]==true) return;
        p=p.search(board[i][j]);
        if (p==null) return;
        if (p.isnode) {
            nums[p.ind]=true;
        }
        run[i][j]=true;
        search(p,board,i-1,j);
        search(p,board,i,j-1);
        search(p,board,i+1,j);
        search(p,board,i,j+1);
        run[i][j]=false;
        // s+=board[i][j];

    }
    public List<String> findWords(char[][] board, String[] words) {
        nums=new boolean[words.length];
        Trie tree=new Trie();
        Integer p;
        for (int i=0;i<words.length;i++){
            tree.insert(words[i],i);
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                run=new boolean[board.length][board[0].length];
                search(tree,board, i, j);
            }
        }
        ArrayList<String> res=new ArrayList<String>();
        for (int i=0;i<words.length;i++){
            if (nums[i])
                res.add(words[i]);
        }        
        return res;
        
    }
}
// @lc code=end

