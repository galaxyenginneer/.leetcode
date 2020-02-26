/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode w;
    boolean track(TreeNode p,TreeNode q){
        if (q==null)return true;
        if(p==null) return false;
        if(q.val!=p.val) return false;
        return track(p.left, q.left) & track(p.right, q.right);
    }
    boolean search(TreeNode p){
        if (p==null)return false;
        if (p.val==w.val){
            if (track(p,w)) return true;
        }
        return search(p.left) | search(p.right);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null)return false;
        if(A==null)return false;
        w=B;
        return search(A);
    }
}