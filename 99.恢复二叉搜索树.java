import javax.swing.tree.TreeNode;

import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (53.61%)
 * Likes:    99
 * Dislikes: 0
 * Total Accepted:    6.8K
 * Total Submissions: 12.6K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 
 * 请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * 输出: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * 输出: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 进阶:
 * 
 * 
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public void midtrace(TreeNode p,ArrayList<TreeNode> l, ArrayList<Integer> v){
        if (p==null) return;
        midtrace(p.left,l,v);
        l.add(p);
        v.add(p.val);
        midtrace(p.right, l,v);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> tree_list=new ArrayList<TreeNode>();
        ArrayList<Integer> val_list=new ArrayList<Integer>();
        midtrace(root,tree_list,val_list);
        // Collections.sort(val_list, new Comparator<TreeNode>() {
        //     @Override
        //     public int compare(TreeNode t1, TreeNode t2) {
        //         return int(t1.val-t2.val);
        //     }
        Collections.sort(val_list);
        for (int i=0;i< tree_list.size();i++){
            tree_list.get(i).val=val_list.get(i);
        }
    }
}
// @lc code=end
