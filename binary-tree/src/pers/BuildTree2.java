package pers;

import java.util.Stack;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author cck
 */
public class BuildTree2 {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode build(
            int[] inorder, int[] postorder, 
            int il, int ir, int pl, int pr) {
     
        if (il > ir | pl > pr) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pr]);
        
        int mid = 0;
        for (int i = il; i <= ir; i++) {
            
            // mid就是中序遍历根节点的位置，mid左边是左子树的中序序列，右边是右子树的中序序列
            // mid可以用来计算左子树有多个节点，mid-il 就是左子树的节点数量
            if (inorder[i] == postorder[pr]) {
                mid = i;
                break;
            }
        }
        
        root.left = build(inorder, postorder, il, mid-1, pl, pl+mid-il-1);
        root.right = build(inorder, postorder, mid+1, ir, pl+mid-il, pr-1);
        
        return root;
    }
    
    public static void main(String[] args) {
        
        BuildTree2 obj = new BuildTree2();
        TreeNode root = obj.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(root);
        
        // 中序遍历一下
        Stack<TreeNode> stack = new Stack<>();
        
        while (!stack.isEmpty() || root != null) {
            
            if (root != null) {
                
                stack.push(root);
                root = root.left;
            } else {
                
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
            
        }
    }
    
}
