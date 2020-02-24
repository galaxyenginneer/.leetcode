import java.util.List;

/*
 * @lc app=leetcode.cn id=330 lang=java
 *
 * [330] 按要求补齐数组
 *
 * https://leetcode-cn.com/problems/patching-array/description/
 *
 * algorithms
 * Hard (40.05%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    1.6K
 * Total Submissions: 4K
 * Testcase Example:  '[1,3]\n6'
 *
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n]
 * 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,3], n = 6
 * 输出: 1 
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加 [2, 4]。
 * 
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 * 
 * 
 */
import java.util.*;

// @lc code=start
class Solution {
    boolean[] ind;
    public int add(int v){
        // int sum=0;

        for (int i=ind.length-1;i>-1;i--){
            // System.out.println(v);
            if (ind[i] & i+v<ind.length) {
                ind[i+v]=true;
            }
            // sum++;
        }
        return 0;
        // return sum-1;
    }
    public int fill(int[] nums, int n){
        ind=new boolean[n+1];
        int result=0;
        ind[0]=true;
        int i;
        for (i=0;i<nums.length;i++) {
            if (nums[i]==n) {
                result--;
                break;
            }
        }
        for (i=0;i<nums.length;i++) add(nums[i]);

        // if (!ind[n])result++;
        while(true){
            for (i=0;i<ind.length;i++){
                if (!ind[i]) break;
            }
            if (i==ind.length) break;
            add(i);
            // res.add(i);
            // System.out.println(i);
            result++;
        }
        return result;
    }
    public int minPatches(int[] nums, int n) {
        // List<Integer> res=Arrays.stream(nums).boxed().collect(Collectors.toList());
        int result=0;
        int max=1;
        long m=n;
        if (nums.length==0) ind=new boolean[n+1];
        else {
            max=nums[nums.length-1];
            // System.out.println(max);
            max=max*(max+1)/2;
            if (n>max){
                System.out.println(max);
                // double tmp=Math.log(1.0*n/max)/Math.log(2);
                // result+=tmp;
                // if (tmp==Math.round(tmp)) result--;
                // result--;
                m=max;
                while(m<n){
                    m=m*2+1;
                    System.out.println(m);
                    result++;
                }
                n=max;
                System.out.println(result);
            }
            else ind=new boolean[n+1];
        }
        result+=fill(nums, n);
        // int num=0;
        return result;
    }
}
    // [1,2,31,33]
    // 2147483647
// @lc code=end

