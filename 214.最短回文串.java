/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 *
 * https://leetcode-cn.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (30.82%)
 * Likes:    109
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 17.8K
 * Testcase Example:  '"aacecaaa"'
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * 
 * 示例 1:
 * 
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * 
 */

// @lc code=start
class Solution {
    public static  String reverse(String str){
        //方法一 将字符串转换为字符数组
        char[] arr = str.toCharArray();
        // 逆序输出字符数组
        for(int i = 0;i<arr.length/2;i++){
            char temp;
            temp = arr[i];
            arr[i] = arr[arr.length-i-1] ;
            arr[arr.length-i-1] = temp;
        }
        return new String(arr);
    }

    public String shortestPalindrome(String s) {
        s=reverse(s);
        // char[] origin=reverse(s).toCharArray();
        // char[] add=new char[s.length()];
        int num=s.length();
        String res=new String();
        for(int i=num;i<=num*2;i++){
            boolean work=true;
            int j=(i+1)/2;
            for (;j<num;j++){
                if (s.charAt(j)!=s.charAt(i-1-j)){
                    work=false;
                    break;
                }
            }
            j=i-j;
            if (work){
                res=s.substring(0, j)+reverse(s);
                System.out.println(res);
                break;
            }
        }
        return res;
    }
}
// @lc code=end

