package pers;

import java.util.Stack;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author cck
 */
public class BuildTree1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(
            int[] preorder, int[] inorder, 
            int pl, int pr, int il, int ir) {
        
        if (pl > pr || il > ir) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pl]);
        
        int mid = 0;
        for (int i = il; i <= ir; i++) {

			// mid就是中序遍历根节点的位置，mid左边是左子树的中序序列，右边是右子树的中序序列
            // mid可以用来计算左子树有多个节点，mid-il 就是左子树的节点数量
            if (inorder[i] == preorder[pl]) {
                mid = i;
                break;
            }
        }
        
        root.left = build(preorder, inorder, pl+1, pl+mid-il, il, mid-1);
        root.right = build(preorder, inorder, pl+mid-il+1, pr, mid+1, ir);
        
        return root;
    }
    
    public static void main(String[] args) {
        
        BuildTree1 obj = new BuildTree1();
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
