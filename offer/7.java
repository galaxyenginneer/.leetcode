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
    int[] pre;
    int[] in;
    TreeNode search(int[] list){
        if(list[0]>list[1])return null;
        int t=pre[list[0]],i;
        for(i=list[2];i<=list[3];i++){
            if (in[i]==t) break;
        }
        TreeNode node=new TreeNode(t);
        int[] now=new int[]{list[0]+1,i+list[0]-list[2],list[2],i-1};
        node.left=search(now);
        now=new int[]{i+list[0]-list[2]+1,list[1],i+1,list[3]};
        node.right=search(now);
        return node;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=preorder;
        in=inorder;
        TreeNode root=search(new int[]{0,preorder.length-1,0,preorder.length});
        return root;
    }
}