import java.util.*;

// import javax.swing.tree.TreeNode;
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
    List<List<Integer>> res;
    Queue<TreeNode> que;
    Queue<Integer> val;
    void add(TreeNode p,int key){
        if (p==null) return;
        que.offer(p);
        val.offer(key);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        res=new ArrayList<List<Integer>>(200);
        if (root==null) return res;
        que=new LinkedList<>();
        val=new LinkedList<>();
        que.offer(root);val.offer(0);
        while(que.size()>0){
            TreeNode p=que.poll();
            int key=val.poll();
            if (key==res.size()){
                res.add(new ArrayList<>());
            }
            res.get(key).add(p.val);
            add(p.left,key+1);
            add(p.right,key+1);
        }
        for (int i=0;i<res.size();i++){
            if(i%2==1) Collections.reverse(res.get(i));
        }
        return res;
    }
}