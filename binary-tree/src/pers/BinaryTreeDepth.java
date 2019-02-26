package pers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的深度
 * @author cck
 */
public class BinaryTreeDepth {
    
    /**
     * 递归求解最大深度
     * @param root
     * @return
     */
    public int maxDepthRecursion(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepthRecursion(root.left);
        int rightDepth = maxDepthRecursion(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    /**
     * 采用层次遍历求解最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            depth++;
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return depth;
    }
    
    /**
     * 递归求解最小深度
     * （加截断判断会更好）
     * @param root
     * @return
     */
    public int minDepthRecursion(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right == null) {
            return minDepthRecursion(root.left) + 1;
        }
        if (root.left == null && root.right != null) {
            return minDepthRecursion(root.right) + 1;
        }
        
        int leftDepth = minDepthRecursion(root.left);
        int rightDepth = minDepthRecursion(root.right);
        
        return Math.min(leftDepth, rightDepth) + 1;
    }
    
    /**
     * 采用层次遍历求解最大深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            depth++;
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                
                if (node.left == null && node.right == null) {
                    return depth;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return depth;
    }
    
}
