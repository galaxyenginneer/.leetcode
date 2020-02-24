import java.util.ArrayList;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (42.54%)
 * Likes:    128
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 31.6K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 示例: 
 * 
 * 你可以将以下二叉树：
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);
        int num=0;
        while (queue.size() > 0) {
            TreeNode p=queue.poll();
            if (p==null){
                // System.out.println("null");
                res.add(null);
                continue;
            }
            // System.out.println(p.val);
            res.add(p.val);
            num=res.size();
            queue.offer(p.left);
            queue.offer(p.right);
        }
        res=res.subList(0, num);
        System.out.println(res.toString());
        return res.toString().replaceAll(" ", "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        data=data.substring(1,data.length()-1);
        System.out.println(data);
        if(data.length()==0) return null;
        String[] datas=data.split(",");
        if (datas.length%2==0) {
            data=data.concat(",null");
            System.out.println(data);
            datas=data.split(",");
        }
        TreeNode[] nodes=new TreeNode[datas.length];
        nodes[0]=new TreeNode(Integer.parseInt(datas[0]));
        int p=0;
        for (int i=1;i<datas.length;i+=2){
            System.out.println(datas[i]);
            System.out.println(datas[i+1]);
            nodes[i]=datas[i].equals("null")?null:new TreeNode(Integer.parseInt(datas[i]));
            nodes[i+1]=datas[i+1].equals("null")?null:new TreeNode(Integer.parseInt(datas[i+1]));
            nodes[p].left=nodes[i];
            nodes[p].right=nodes[i+1];
            p++;
            while(nodes[p]==null) p++;
        }
        return nodes[0];
        // res=new ArrayList<Integer>(Arrays.asList(data.split(",")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
