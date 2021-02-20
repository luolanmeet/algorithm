package pers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 958. 二叉树的完全性检验
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * @author cck
 */
public class CompleteTree {
    
    public boolean isCompleteTree(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        int level = 1;
        boolean isFillLevel = true;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            // 判读数量是否正确
            if (isFillLevel) {
                
                int levelSize = (int) Math.pow(2, level - 1);
                
                if (size != levelSize) {
                    return false;
                }
            }
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                
                if (node.left == null && node.right != null) {
                    return false;
                }
                
                if (node.left != null) {
                    
                    if (!isFillLevel) {
                        return false;
                    }
                    
                    queue.offer(node.left);
                } else {
                    isFillLevel = false;
                }
                
                if (node.right != null) {
                    
                    if (!isFillLevel) {
                        return false;
                    }
                    
                    queue.offer(node.right);
                } else {
                    isFillLevel = false;
                }
            }
            
            level++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
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
        
        CompleteTree obj = new CompleteTree();
        System.out.println(obj.isCompleteTree(t1));
        
        t3.left = null;
        t3.right = t6;
        System.out.println(obj.isCompleteTree(t1));
        
    }
    
}
