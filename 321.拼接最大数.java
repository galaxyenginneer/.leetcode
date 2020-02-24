/*
 * @lc app=leetcode.cn id=321 lang=java
 *
 * [321] 拼接最大数
 *
 * https://leetcode-cn.com/problems/create-maximum-number/description/
 *
 * algorithms
 * Hard (26.01%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 7.1K
 * Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
 *
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)
 * 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * 
 * 示例 1:
 * 
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 
 * 示例 2:
 * 
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 
 * 示例 3:
 * 
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * 
 */
import java.util.*;


// @lc code=start
class Solution {
    int[] sum;
    public int add(List<Integer> res,List<Integer> nums,int b,int e){
        for (int i=b;i<=e;i++){
            res.add(nums.get(i));
        }
        return e+1;
    }
    public double find(List<Integer> res,int ind){
        for (int i=ind;i<res.size();i++){
            if (res.get(i)==res.get(ind)) continue;
            if (res.get(i)>res.get(ind)) return res.get(i)/Math.pow(10,i-ind); 
            if (res.get(i)<res.get(ind)) return -1; 
        }
        return -1;
    }
    public boolean cmp(List<Integer> nums1,List<Integer> nums2,int i,int j){
        // boolean res=false;
        while(nums1.get(i)==nums2.get(j)){
            i++;
            j++;
            if(i==nums1.size()) return false;
            if(j==nums2.size()) return true;
        }
        return nums1.get(i)>nums2.get(j);
    }
    public void merge(List<Integer> nums1,List<Integer> nums2){
        System.out.println(nums1.toString());
        System.out.println(nums2.toString());
        List<Integer> res=new ArrayList<Integer>();
        int i=0,j=0;
        while(true){
            if (i>=nums1.size()) {
                while(j<nums2.size()) {
                    res.add(nums2.get(j));
                    j++;
                }
                break;
            }
            if (j>=nums2.size()) {
                while(i<nums1.size()) {
                    res.add(nums1.get(i));
                    i++;
                }
                break;
            }
            if(cmp(nums1,nums2,i,j)){
                res.add(nums1.get(i));
                i++;
            }else {
                res.add(nums2.get(j));
                j++;
            } 
        }
        System.out.println(res.toString());
        for (i=0;i<res.size();i++){
            if (res.get(i)>sum[i])break;
            if (res.get(i)<sum[i])return;
        }
        // System.out.println(nums1.toString());
        // System.out.println(nums2.toString());
        // System.out.println(res.toString());
        for(i=0;i<sum.length;i++){
            sum[i]=res.get(i);
        }

    }
    public void delete(List<Integer> res,int k){
        for (int i=1;i<res.size();i++){

            if (k==0) break;
            while (res.get(i)>res.get(i-1)){
                // System.out.println(i);
                // System.out.println(res.toString());
                if (k==0) break;
                res.remove(i-1);
                i--;
                k--;
                if (i==0)break;
            }
        }

        while(k>0){
            if (res.size()==0) return;
            res.remove(res.size()-1);
            k--;
        }
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // List<Integer> res=new ArrayList<Integer>();
        // int i=0,j=0;
        sum=new int[k];
        k=nums1.length+nums2.length-k;
        for (int i=Math.max(0,k-nums2.length);i<=Math.min(nums1.length,k);i++){
            List<Integer> res1=Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> res2=Arrays.stream(nums2).boxed().collect(Collectors.toList());
            delete(res1, i);
            delete(res2, k-i);
            merge(res1,res2);
        }
        return sum;
    }
}

// [2, 1, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 2, 2, 1, 1, 0, 1, 2, 1, 2, 1, 0, 1, 2, 2, 2, 2, 1, 1, 0, 2, 0, 1, 0, 1, 
// [2, 1, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 2, 2, 1, 1, 0, 1, 2, 1, 2, 1, 0, 1, 2, 2, 2, 2, 1, 1, 0, 2, 0, 1, 0]

// @lc code=end

