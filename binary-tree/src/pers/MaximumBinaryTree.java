package pers;

import java.util.Stack;

/**
 * 654. 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * @author cck
 */
public class MaximumBinaryTree {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        
        if (l > r) {
            return null;
        }
        
        int index = l;
        int max = nums[l];
        
        for (int i = l; i <= r; i++) {
            
            if (nums[i] > max) {
                index = i;
                max = nums[i]; 
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = build(nums, l, index-1);
        root.right = build(nums, index+1, r);
        
        return root;
    }
    
    public static void main(String[] args) {
        
        MaximumBinaryTree obj = new MaximumBinaryTree();
        TreeNode root = obj.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(root);
        
        // 后续遍历一下
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root);
        
        while (!stack1.isEmpty()) {
            
            TreeNode node = stack1.pop();
            stack2.push(node);
            
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.val + " ");
        }
    }
    
}
