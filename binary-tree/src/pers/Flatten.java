package pers;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @author cck
 */
public class Flatten {
    
    // 用前序遍历即可，遍历的过程中，将右子树的第一个节点拼接在左子树最后一个节点上，左子树作为新的右子树
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return ;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode preNode = new TreeNode(0);
        
        while (!stack.isEmpty()) {
            
            TreeNode node = stack.pop();
            preNode.right = node;
            preNode.left = null;
            
            preNode = node;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    
}
