/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int target;
    List<Integer>now=new ArrayList<Integer>();
    void search(TreeNode p,int sum){
        if (p==null)return;
        sum+=p.val;
        now.add(p.val);
        if (p.left==null&p.right==null){
            if (sum==target){
                res.add(new ArrayList<Integer>(now));
            }
            now.remove(now.size()-1);
            return;
        }
        search(p.left,sum);
        search(p.right,sum);
        now.remove(now.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target=sum;
        search(root,0);
        return res;
    }
}