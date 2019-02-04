package pers.traversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import pers.TreeNode;

/**
 * 前序、中序、后序、层次遍历 
 * @author cck
 */
public class BinaryTreeTraversal {
    
    /**
     * 前序遍历
     */
    public static void pre(TreeNode head) {
        
        if (head == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        
        while (!stack.isEmpty()) {
            
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");
            
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
    
    /**
     * 中序遍历
     */
    public static void mid(TreeNode head) {
        
        if (head == null) {
            return ;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        while (!stack.isEmpty() || head != null) {
            
            if (head != null) {
                
                stack.push(head);
                head = head.left;
                
            } else {
                
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }
    
    /**
     * 后序遍历
     */
    public static void post(TreeNode head) {
        
        if (head == null) {
            return ;
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(head);
        
        while (!stack1.isEmpty()) {
            
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }
        
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }
    
    /*
     * 层次遍历
     */
    public static void level(TreeNode head) {
        
        if (head == null) {
            return ;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode left = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        
        root.left = left;
        root.right = right;
        
        pre(root);
        System.out.println();
        
        mid(root);
        System.out.println();
        
        post(root);
        System.out.println();
        
        level(root);
    }
    
}
