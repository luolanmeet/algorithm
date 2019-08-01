package pers.sword;

import java.util.Stack;

/**
 * 通过前序遍历和中序遍历重建二叉树
 * @author cck
 */
public class Algorithm6 {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
    
        if (pl > pr || il > ir) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pl]);
        
        // 找到中点
        int mid = 0;
        for (int i = il; i <= ir; i++) {
        
            if (preorder[pl] == inorder[i]) {
                mid = i;
                break;
            }
        }
        // (mid - il) 表示左子树的节点数量
        root.left = build(preorder, inorder, pl + 1, pl + (mid - il), il, mid - 1);
        root.right = build(preorder, inorder, pl + (mid - il) + 1, pr, mid + 1, ir);
        
        return root;
    }
    
    public static void main(String[] args) {
        Algorithm6 obj = new Algorithm6();
        TreeNode root = obj.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    
        // 前序遍历一下
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
        
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    
}
