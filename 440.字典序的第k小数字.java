import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=440 lang=java
 *
 * [440] 字典序的第K小数字
 *
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/description/
 *
 * algorithms
 * Hard (29.62%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    2.4K
 * Total Submissions: 7.5K
 * Testcase Example:  '13\n2'
 *
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 
 * 注意：1 ≤ k ≤ n ≤ 10^9。
 * 
 * 示例 :
 * 
 * 
 * 输入:
 * n: 13   k: 2
 * 
 * 输出:
 * 10
 * 
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findKthNumber(int n, int k) {
        String s=Integer.toString(n);
        int[] nums=new int[s.length()];
        for(int i=0;i<s.length();i++) nums[i]=s.charAt(i)-'0';
        int now=0;
        int num=0;
        int in=0;
        List<Integer> res=new ArrayList<Integer>();
        for (num=0;num<s.length();num++){
            if (now==k) break;
            int i=num==0?1:0;
            in*=10;
            for(;i<=9;i++){
                int is=in+nums[num]-i;
                int tmp=0;
                if (is<0){
                    for (int w=0;w<nums.length-1-num;w++){
                        tmp+=Math.pow(10,w);
                    }
                }else if(is>0){
                    for (int w=0;w<nums.length-num;w++){
                        tmp+=Math.pow(10,w);
                    }
                }else{
                    for (int w=0;w<nums.length-1-num;w++){
                        tmp+=Math.pow(10,w);
                    }
                    for (int w=num+1;w<nums.length;w++){
                        tmp+=Math.pow(10,nums.length-1-w)*nums[w];
                    }
                    tmp+=1;
                }
                // System.out.println(i+" "+tmp);
                if (now+tmp>=k) break;
                now+=tmp;
            }
            res.add(i);
            now++;
            System.out.println("add "+i+" "+now);
            in=in+nums[num]-i;
        }
        int sum=0;
        for (int w=0;w<res.size();w++){
            sum+=Math.pow(10,res.size()-1-w)*res.get(w);
        }
        return sum;
    }
}
// @lc code=end

