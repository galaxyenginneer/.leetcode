import java.util.ArrayList;
import java.util.*;

/*
 * @lc app=leetcode.cn id=479 lang=java
 *
 * [479] 最大回文数乘积
 *
 * https://leetcode-cn.com/problems/largest-palindrome-product/description/
 *
 * algorithms
 * Hard (30.14%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    1.3K
 * Total Submissions: 4.1K
 * Testcase Example:  '1'
 *
 * 你需要找到由两个 n 位数的乘积组成的最大回文数。
 * 
 * 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
 * 
 * 示例:
 * 
 * 输入: 2
 * 
 * 输出: 987
 * 
 * 解释: 99 x 91 = 9009, 9009 % 1337 = 987
 * 
 * 说明:
 * 
 * n 的取值范围为 [1,8]。
 * 
 */

// @lc code=start
class Solution {
    List<Integer> sum=new ArrayList<Integer>();
    List<Integer> a=new ArrayList<Integer>();
    List<Integer> b=new ArrayList<Integer>();
    public boolean check(){
        for (int i=0;i<sum.size()/2;i++){
            if (sum.get(i)!=sum.get(sum.size()-i-1)) return false;
        }
        return true;
    }
    public void delete(List<Integer> s,int ind){
        int i=ind;
        // int add=-1;
        while(i<s.size()){
            int val=s.get(i);
            val-=1;
            if (val>-1){
                s.set(i, val);
                break;
            }else{
                s.set(i, 9);
            }
            i++;
        }
        if(s.get(s.size()-1)==0)s.remove(s.size()-1);
    }
    public void delete(List<Integer> a,List<Integer> b){
        int add=0;
        for (int i=0;i<b.size();i++){
            int val=a.get(i)-b.get(i)-add;
            if (val<0){
                a.set(i, 10+val);
                add=1;
            }else {
                a.set(i, val);
                add=0;
            }
        }
        if (add>0) delete(a,b.size());
    }
    public int largestPalindrome(int n) {
        // long a=0,b=0,sum,min;
        for (int i=0;i<n;i++){
            a.add(9);
            b.add(9);
        }
        sum.add(1);
        for (int i=0;i<n-1;i++) sum.add(0);
        sum.add(8);
        for (int i=0;i<n-1;i++){
            sum.add(9);
        }
        while(a.size()==n){
            // sum=a*b;
            if(check()){
                break;
            }
            if (a==b){
                a--;
                sum-=b;
            }else{
                b--;
                sum-=a;
            }
        }
        sum%=1337;
        return (int)sum;

    }
}
// @lc code=end

