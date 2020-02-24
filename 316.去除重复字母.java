import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 *
 * https://leetcode-cn.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Hard (35.28%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 18K
 * Testcase Example:  '"bcabc"'
 *
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 * 示例 1:
 * 
 * 输入: "bcabc"
 * 输出: "abc"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * 
 */

// @lc code=start
class Solution {
    List<Character> c=new ArrayList<Character>();
    // boolean [] state;
    String origin;
    String res="";
    int[] now;
    // int[] final;
    List<List<Integer>> list;
    public void gen(){
        int[] tmp=now.clone();
        Arrays.sort(tmp);
        StringBuilder str = new StringBuilder();
        for (int p:tmp){
            str.append(origin.charAt(p));
        }
        String s=str.toString();
        if (s.compareTo(res)<0){
            res=s;
        }
    }
    public int next(char ch,int ind){
        int num=ch-'a';
        List<Integer> tmp=list.get(num);
        if (tmp.size()==0) return -1;
        for (int i=0;i<tmp.size();i++){
            if (tmp.get(i)>=ind) return tmp.get(i);
        }
        return -1;
    }
    public boolean search(int ind){
        if (ind==c.size()){
            gen();
            return false;
        }
        System.out.println(ind);
        int num=c.get(ind)-'a';
        List<Integer> tmp=list.get(num);
        for (int i=0;i<tmp.size();i++){
            now[ind]=tmp.get(i);
            search(ind+1);
        }
        return false;

    }
    public String removeDuplicateLetters(String s) {
        // boolean []tmp=new boolean[26];
        origin=s;
        list=new ArrayList<List<Integer>>();
        for (int i=0;i<26;i++){
            list.add(new ArrayList<Integer>());
        }
        for (int i=0;i<s.length();i++){
            int ind=s.charAt(i)-'a';
            list.get(ind).add(i);
            // tmp[]=true;
        }
        for (int i=0;i<26;i++){
            if (list.get(i).size()>0){
                System.out.println(list.get(i).size());
                Character ch = (char)('a'+i);
                c.add(ch);
            }
        }
        now=new int[c.size()];
        StringBuilder str = new StringBuilder();
        for (int i=c.size()-1;i>-1;i--){
            str.append(c.get(i));
        }
        res=str.toString();

        System.out.println(c.size());
        // state=new boolean[c.size()];
        search(0);
        return res;
    }
}
// @lc code=end

