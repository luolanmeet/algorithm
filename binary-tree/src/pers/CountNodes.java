package pers;

import java.util.Stack;

/**
 * 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/ 
 * @author cck
 */
public class CountNodes {
    
    // 用任何一种遍历都能求解
    public int countNodes(TreeNode root) {
        
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                
                root = stack.pop();
                res++;
                root = root.right;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        CountNodes obj = new CountNodes();
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        
        System.out.println(obj.countNodes(t1));
    }
    
}
