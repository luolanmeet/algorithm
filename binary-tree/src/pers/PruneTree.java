package pers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 * @author cck
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        
        pruneTree(root.left, root, true);
        pruneTree(root.right, root, false);
        
        return root;
    }
    
    public void pruneTree(TreeNode root, TreeNode preNode, boolean isLeft) {
        
        if (root == null) {
            return ;
        }
        
        pruneTree(root.left, root, true);
        pruneTree(root.right, root, false);
        
        if (root.left == null && root.right == null && root.val == 0) {
            
            if (isLeft) {
                preNode.left = null;
            } else {
                preNode.right = null;
            }
        }
    }
    
    public static void main(String[] args) {
        
        PruneTree obj = new PruneTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(1);
        
        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        
        TreeNode node = obj.pruneTree(t1);
        
        // 层次遍历一下
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode temp = queue.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        
    }
    
}
