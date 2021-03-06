import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (40.22%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    10.1K
 * Total Submissions: 23.9K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n' +
  '[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 
 * 例如，
 * 
 * [2,3,4] 的中位数是 3
 * 
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 
 * 设计一个支持以下两种操作的数据结构：
 * 
 * 
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 
 * 
 * 示例：
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 进阶:
 * 
 * 
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 
 * 
 */

// @lc code=start
class MedianFinder {

    /** initialize your data structure here. */
    // int pointer=-1;
    ArrayList<Integer> nums=new ArrayList<Integer>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int right=nums.size(),left=0,mid=0;
        if (right==0){
            nums.add(0,num);
            return;
        }
        while(left<right){
            mid=(left+right)/2;
            if (nums.get(mid)==num){
                nums.add(mid,num);
                return;
            }
            if (nums.get(mid)<num){
                left=mid+1;
                mid=left;
            }else{
                right=mid;
                mid=right;
            }
        }
        // System.out.println(mid);
        nums.add(mid,num);
        // System.out.println(nums.toString());
    }
    
    public double findMedian() {
        // double sum;
        int mid=nums.size();
        if (mid%2==1){
            return nums.get(mid/2);
        }
        double sum=nums.get(mid/2)+nums.get(mid/2-1);
        return sum/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

