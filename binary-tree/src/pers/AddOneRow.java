package pers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode-cn.com/problems/add-one-row-to-tree/
 * @author cck
 */
public class AddOneRow {
    
    // 层次遍历到指定层，然后为那一层的节点添加新的节点
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        
        d--;
        
        if (d <= 0) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            // 到达指定的层次
            if (level == d) {
                
                for (int i = 0; i < size; i++) {
                    
                    TreeNode node = queue.poll();
                    
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    newLeft.left = node.left;;
                    newRight.right = node.right;;
                    
                    node.left = newLeft;
                    node.right = newRight;
                }
                
                return root;
            }
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        
        TreeNode newRoot = new TreeNode(v);
        newRoot.left = root;
        return newRoot;
    }
    
}
