import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 *
 * https://leetcode-cn.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (56.48%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 12.7K
 * Testcase Example:  '[3,1,5,8]'
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的
 * left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 
 * 求所能获得硬币的最大数量。
 * 
 * 说明:
 * 
 * 
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * 示例:
 * 
 * 输入: [3,1,5,8]
 * 输出: 167 
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 * 
 */

// @lc code=start
class Solution {
    List<Integer> list;
    public int mul(int i){
        int left=i==0?1:list.get(i-1);
        int right=i==list.size()-1?1:list.get(i+1);
        return left*right*list.get(i);
    }
    public double get(int i){
        int left=i==0?1:list.get(i-1);
        int right=i==list.size()-1?1:list.get(i+1);
        double mid=list.get(i);
        if (left>mid & mid <right) return left*right;
        return mid;
        // return left*right;
        // return (left-mid)*right+(right-mid)*left;
    }
    public int maxCoins(int[] nums) {
        list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        // int [] val=new int[101];
        for (int i=0;i<list.size();i++){
            if (list.get(i)==0){
                list.remove(i);
                i--;
                continue;
            }
            // val[nums[i]]++;
        }
        if (list.size()==0) return 0;
        if(list.size()==1) return list.get(0);
        // val[list.get(0)]--;
        // val[list.get(list.size()-1)]--;
        // int p=0,w=0;
        int sum=0;
        while(list.size()>2){
            int max=1;
            for (int i=1;i<list.size()-1;i++){
                if (get(i)>get(max)) max=i;
            }
            System.out.println(list.get(max));
            // System.out.println(mul(max));
            sum+=mul(max);
            list.remove(max);
            System.out.println(list.toString());
        }

        sum+=list.get(0)*list.get(1)+Math.max(list.get(0),list.get(1));
        return sum;
    }
}
// [9,76,64,21,97,60,5]
// [35,16,83,87,84,59,48,41,20]

// @lc code=end

