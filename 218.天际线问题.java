/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 *
 * https://leetcode-cn.com/problems/the-skyline-problem/description/
 *
 * algorithms
 * Hard (39.54%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    4.6K
 * Total Submissions: 11.3K
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * 
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 * 
 * ⁠   
 * 
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0
 * ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0
 * 的表面上的完美矩形。
 * 
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
 * 。
 * 
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]
 * ]。
 * 
 * 说明:
 * 
 * 
 * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
 * 输入列表已经按左 x 坐标 Li  进行升序排列。
 * 输出列表必须按 x 位排序。
 * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...]
 * 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

// @lc code=start
class Solution {
    ArrayList<int[]> res = new ArrayList<int[]>();
    public int search(int val){
        // int begin;
        int k=0;
        for (;k<res.size();k++){
            if (res.get(k)[0]>val){
                return k;
            }
        }
        return k;

    }
    public void clear(){
        for (int k=0;k<res.size()-1;k++){
            // if (res.get(k)[0]==res.get(k-1)[0]){
                if (res.get(k)[0]==res.get(k+1)[0]){
                    res.remove(k);
                    k--;
                }
            // }
        }
        for (int k=0;k<res.size()-1;k++){
            // if (res.get(k)[0]==res.get(k-1)[0]){
                if (res.get(k)[1]==res.get(k+1)[1]){
                    res.remove(k+1);
                    k--;
                }
            // }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        for (int i=0;i<buildings.length;i++){
            int begin,end;
            begin=search(buildings[i][0]);
            end=search(buildings[i][1]);
            System.out.println(""+begin+end);
            if (begin==res.size()){
                int[] tmp=new int[]{buildings[i][0],buildings[i][2]};
                // if (tmp[0]==res.get(res.size()-1)[1])
                res.add(tmp);
                tmp=new int[]{buildings[i][1],0};
                res.add(tmp);
                continue;
            }

            if (end==res.size()){
                res.add(end, new int[]{buildings[i][1],0});
            }else if (res.get(end)[1]<buildings[i][2]){
                res.add(end, new int[]{buildings[i][1],res.get(end-1)[1]});
            }
            if (res.get(begin-1)[1]<buildings[i][2]){
                res.add(begin, new int[]{buildings[i][0],buildings[i][2]});
                begin++;
                end++;
            }
            for(int j=begin;j<end;j++){
                if (res.get(j)[1]<buildings[i][2]) res.get(j)[1]=buildings[i][2];
            }
            clear();
        }
        clear();
        List<List<Integer>> sum=new ArrayList<List<Integer>>();
        for (int[] p:res){
            sum.add(Arrays.stream(p).boxed().collect(Collectors.toList()));
        }
        return sum;
    }
}
// [[2,4,70],[3,8,30],[6,100,41],[7,15,70],[10,30,102],[15,25,76],[60,80,91],[70,90,72],[85,120,59]]
// [[2,70],[4,30],[6,41],[7,70],[10,102],[30,41],[60,91],[80,72],[90,59],[120,0]]
// [[2,13,10],[10,17,25],[12,20,14]]

// @lc code=end

