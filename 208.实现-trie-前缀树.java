import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (62.47%)
 * Likes:    192
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 35.7K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
    ArrayList<Trie> sonList=new ArrayList<Trie>();
    // int[] pos=new int[26];
    // int num
    char val;
    Boolean isnode=false;
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Boolean find=false;
        Trie next=new Trie();;
        if (word.length()==0) {
            isnode=true;
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
        next.insert(word.substring(1));
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Boolean find=false;
        int next=0;
        if (word.length()==0) {
            if (isnode) return true;
            else return false;
        }
        for (Trie p:sonList){
            if (p.val==word.charAt(0)) {
                find=true;
                break;
            }
            next++;
        }
        if (!find){
            return false;
        }
        return sonList.get(next).search(word.substring(1));
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Boolean find=false;
        int next=0;
        if (prefix.length()==0) {
            return true;
        }
        for (Trie p:sonList){
            if (p.val==prefix.charAt(0)) {
                find=true;
                break;
            }
            next++;
        }
        if (!find){
            return false;
        }
        return sonList.get(next).startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

