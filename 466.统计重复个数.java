/*
 * @lc app=leetcode.cn id=466 lang=java
 *
 * [466] 统计重复个数
 *
 * https://leetcode-cn.com/problems/count-the-repetitions/description/
 *
 * algorithms
 * Hard (29.04%)
 * Likes:    26
 * Dislikes: 0
 * Total Accepted:    918
 * Total Submissions: 3K
 * Testcase Example:  '"acb"\n4\n"ab"\n2'
 *
 * 定义由 n 个连接的字符串 s 组成字符串 S，即 S = [s,n]。例如，["abc", 3]=“abcabcabc”。
 * 
 * 另一方面，如果我们可以从 s2 中删除某些字符使其变为 s1，我们称字符串 s1 可以从字符串 s2 获得。例如，“abc” 可以根据我们的定义从
 * “abdbec” 获得，但不能从 “acbbe” 获得。
 * 
 * 现在给出两个非空字符串 S1 和 S2（每个最多 100 个字符长）和两个整数 0 ≤ N1 ≤ 10^6 和 1 ≤ N2 ≤
 * 10^6。现在考虑字符串 S1 和 S2，其中S1=[s1,n1]和S2=[s2,n2]。找出可以使[S2,M]从 S1 获得的最大整数 M。
 * 
 * 示例：
 * 
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 * 
 * 返回：
 * 2
 * 
 * 
 */
import java.util.*;

// @lc code=start
class Solution {
    public int find(String s1,String s2){
        int res=0;
        int i=0,j=s2.length(),mul=0;
        // Map<Integer,Integer> m=new HashMap<Integer,Integer>();
        int begin=-1;
        List<int []> m=new ArrayList<int []>();
        int tmp=begin;
        while(true){
            if (j==s2.length()) {
                int [] now=new int[2];
                now[0]=begin;
                now[1]=mul*s1.length()+tmp-begin;
                m.add(begin, now);
                begin=s1.indexOf(s2.charAt(0),begin+1);
                if (begin==-1)break;
                i=begin+1;
                j=1;
                mul=0;
                // m.put(begin, value)
                // res++;
            }
            tmp=s1.indexOf(s2.charAt(j),i);
            if (tmp==-1){
                mul++;
                tmp=s1.indexOf(s2.charAt(j),0);
                if (tmp==-1) break;
            }
            i=tmp+1;
            j++;
        }
        return res;
    }
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int a=find(s1, s2),b=find(s1+s1, s2),c=find(s1+s1+s1, s2);
        c=c-b;b=b-a;
        a+=(c+b)*((n1-1)/2)+(n1-1)%2*b;
        return a/n2;

    }
}
// @lc code=end

