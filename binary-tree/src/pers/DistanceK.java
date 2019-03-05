package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * @author cck
 */
public class DistanceK {

    class TreeNode2{
        
        int val;
        TreeNode2 parent;
        TreeNode2 left;
        TreeNode2 right;
        
        TreeNode2(int val) {
            this.val = val;
        }
    }

    TreeNode2 target2;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        if (K == 0) {
            return Arrays.asList(target.val);
        }
        
        copy(null, root, target.val);
        
        List<Integer> res = new ArrayList<>();
        calc(target2, null, K, res);
        
        return new ArrayList<>(res);
    }
    
    private void calc(TreeNode2 node, TreeNode2 preNode, int k, List<Integer> res) {
        
        if (node == null || k < 0) {
            return ;
        }
        if (k == 0) {
            res.add(node.val);
            return;
        }
        
        if (node.parent != preNode) {
            calc(node.parent, node, k - 1, res);
        }
        
        if (node.left != preNode) {
            calc(node.left, node, k - 1, res);
        }
        
        if (node.right != preNode) {
            calc(node.right, node, k - 1, res);
        }
    }

    private TreeNode2 copy(TreeNode2 parent, TreeNode root, int val) {
        
        if (root == null) {
            return null;
        }
        
        TreeNode2 node = new TreeNode2(root.val);
        if (root.val == val) {
            target2 = node;
        }
        
        node.parent = parent;
        node.left = copy(node, root.left, val);
        node.right = copy(node, root.right, val);
        
        return node;
    }
        
    public static void main(String[] args) {
        
        DistanceK obj = new DistanceK();
        
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;
        
        System.out.println(obj.distanceK(t1, t2, 2));
    }
    
}
