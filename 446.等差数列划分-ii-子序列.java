import java.util.ArrayList;

import com.apple.laf.AquaButtonRadioUI.RadioButtonBorder;

/*
 * @lc app=leetcode.cn id=446 lang=java
 *
 * [446] 等差数列划分 II - 子序列
 *
 * https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/description/
 *
 * algorithms
 * Hard (29.78%)
 * Likes:    39
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 3.7K
 * Testcase Example:  '[2,4,6,8,10]'
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 
 * 例如，以下数列为等差数列:
 * 
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 
 * 以下数列不是等差数列。
 * 
 * 1, 1, 2, 5, 7
 * 
 * 
 * 
 * 数组 A 包含 N 个数，且索引从 0 开始。该数组子序列将划分为整数序列 (P0, P1, ..., Pk)，P 与 Q 是整数且满足 0 ≤ P0
 * < P1 < ... < Pk < N。
 * 
 * 
 * 
 * 如果序列 A[P0]，A[P1]，...，A[Pk-1]，A[Pk] 是等差的，那么数组 A 的子序列 (P0，P1，…，PK)
 * 称为等差序列。值得注意的是，这意味着 k ≥ 2。
 * 
 * 函数要返回数组 A 中所有等差子序列的个数。
 * 
 * 输入包含 N 个整数。每个整数都在 -2^31 和 2^31-1 之间，另外 0 ≤ N ≤ 1000。保证输出小于 2^31-1。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：[2, 4, 6, 8, 10]
 * 
 * 输出：7
 * 
 * 解释：
 * 所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 
 * 
 * 
 * 
 */
import java.util.*;
// import java.util.Collections;

// @lc code=start
class Solution {
    int[] s;
    public int find(int ind,long val){
        for(;ind<s.length;ind++){
            if (s[ind]==val) return ind;
            if(s[ind]>val) return -1;
        }
        return -1;
    }
    public int sum(int num){
        int res=0;
        res=(num-2)*(num-1)/2;
        // for (int k=num-2;k>0;k--) res+=k;
        return res;
    }
    public int numberOfArithmeticSlices(int[] A) {
        int res=0;
        List<Integer> val=new ArrayList<Integer>();
        List<Integer> number=new ArrayList<Integer>();
        s=A;
        for (int i=0;i<s.length;i++){
            int last=i==0?s[i]-1:s[i-1];
            if (s[i]!=last){
                val.add(s[i]);
                number.add(1);
            }else{
                number.set(number.size()-1,number.get(number.size()-1)+1);
            }
        }
        for (int i=0;i<number.size();i++){
            int tmp=number.get(i);
            res+=Math.pow(2, tmp)-1-tmp-tmp*(tmp-1)/2;
        }
        // Integer[]s;
        s=new int[val.size()];
        for (int i=0;i<val.size();i++) s[i]=val.get(i);
        boolean[][] now=new boolean[s.length][s.length];
        for (int i=0;i<s.length-2;i++){
            for (int j=i+1;j<s.length-1;j++){
                if (now[i][j])continue;
                System.out.println(i+" "+j);
                int last=j;
                now[i][j]=true;
                int tmp=2;
                int mul=number.get(i)*number.get(j);
                int k=find(last+1,(long)s[last]+s[j]-s[i]);
                while (k>0){
                    // System.out.println(k);
                    mul*=number.get(k);
                    now[last][k]=true;
                    tmp++;
                    last=k;
                    k=find(last+1,s[last]+s[j]-s[i]);
                }
                System.out.println(sum(tmp)+" "+mul);
                res+=sum(tmp)*mul;
            }
            
        }
        return res;
    }
}
// [0,2000000000,-294967296]

// @lc code=end

