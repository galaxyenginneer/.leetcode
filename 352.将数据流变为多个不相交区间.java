/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 *
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/description/
 *
 * algorithms
 * Hard (50.46%)
 * Likes:    21
 * Dislikes: 0
 * Total Accepted:    1.3K
 * Total Submissions: 2.4K
 * Testcase Example:  '["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]\n' +
  '[[],[1],[],[3],[],[7],[],[2],[],[6],[]]'
 *
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 * 
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 * 
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 
 * 
 * 
 * 
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 * 
 * 提示：
 * 特别感谢 @yunhong 提供了本问题和其测试用例。
 * 
 */
import java.util.*;

// @lc code=start
class SummaryRanges {
    List<int []> res=new ArrayList<int []>();
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    public void merge(int ind){
        while(ind<res.size()-1){
            if (res.get(ind)[1]>=res.get(ind+1)[0]-1){
                res.get(ind)[1]=res.get(ind+1)[1];
                res.remove(ind+1);
            }else break;
        }
        while(ind>0){
            if (res.get(ind)[0]<=res.get(ind-1)[1]+1){
                res.get(ind)[0]=res.get(ind-1)[0];
                res.remove(ind-1);
                ind--;
            }else break;
        }
    }
    public void addNum(int val) {
        System.out.println(val);
        int i;
        for(i=0;i<res.size();i++){
            int [] t=res.get(i);
            int a=t[0],b=t[1];
            if (a<=val&b>=val){
                return;
            }
            if (a>val){
                break;
            }
        }

        int [] now=new int[2];      
        now[0]=val;
        now[1]=val;

        res.add(i, now);
        // System.out.println(i);
        merge(i);
        // System.out.println(i);
        return;
    }
    
    public int[][] getIntervals() {
        int [][] sum=new int[res.size()][2];
        for (int i=0;i<res.size();i++){
            sum[i][0]=res.get(i)[0];
            sum[i][1]=res.get(i)[1];
        }
        return sum;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

