import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=273 lang=java
 *
 * [273] 整数转换英文表示
 *
 * https://leetcode-cn.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (24.71%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    3.4K
 * Total Submissions: 12.8K
 * Testcase Example:  '123'
 *
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 2^31 - 1 。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 
 * 示例 3:
 * 
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * 示例 4:
 * 
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven
 * Thousand Eight Hundred Ninety One"
 * 
 */

// @lc code=start
class Solution {
    public String numberToWords(int num) {
        // int[] a=new int[] {0,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
        String[] s1=new String[] {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] s2=new String[] {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] s3=new String[] {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] s4=new String[] {"","Thousand","Million","Billion"};
        String s5="Hundred";
        String s=Integer.toString(num);
        String res="";
        for (int i=0;3*i<=s.length()-3;i++){
            num=Integer.parseInt(s.substring(s.length()-3*i-3, s.length()-3*i));
            if (num==0)continue;
            int a=s.charAt(s.length()-3*i-3)-'0';
            int b=s.charAt(s.length()-3*i-2)-'0';
            int c=s.charAt(s.length()-3*i-1)-'0';
            System.out.println(a);
            String tmp=a>0?s1[a]+" "+s5+" "+s3[b]:s3[b];
            if (b==1) tmp=tmp.concat(s2[c]+" ");
            else {
                if (b!=0) tmp=tmp.concat(" ");
                if (c!=0) tmp=tmp.concat(s1[c]+" ");
            }
            tmp=tmp.concat(s4[i]+" ");
            System.out.println(tmp);
            res=tmp.concat(res);
        }
        if (s.length()%3==0) return res.trim();
        res=" "+s4[s.length()/3]+" "+res;
        if (s.length()%3==1){
            int c=s.charAt(0)-'0';
            res=s1[c]+res;
        }else{
            int b=s.charAt(0)-'0';
            int c=s.charAt(1)-'0';
            if (b==1) res=s2[c]+res;
            else{
                if (c!=0) res=s3[b]+" "+s1[c]+res;
                else res=s3[b]+res;
            }
        }
        return res.trim();
    }
}
// @lc code=end

