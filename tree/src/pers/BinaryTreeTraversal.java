package pers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * 前序、中序、后序、层次遍历 
 * @author cck
 */
public class BinaryTreeTraversal {
    
    /**
     * 前序遍历-迭代
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
     * 前序遍历-递归 
     */
    public static void preRecursion(TreeNode head) {
        
        if (head == null) {
            return ;
        }
        
        System.out.print(head.val + " ");
        preRecursion(head.left);
        preRecursion(head.right);
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
     * 中序遍历-递归 
     */
    public static void midRecursion(TreeNode head) {
        
        if (head == null) {
            return ;
        }
        
        midRecursion(head.left);
        System.out.print(head.val + " ");
        midRecursion(head.right);
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
    
    /**
     * 后序遍历-递归 
     */
    public static void postRecursion(TreeNode head) {
        
        if (head == null) {
            return ;
        }
        
        postRecursion(head.left);
        postRecursion(head.right);
        System.out.print(head.val + " ");
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
        
        TreeNode root = initBT();
        
        System.out.println("前序遍历");
        pre(root);
        System.out.println();
        preRecursion(root);
        System.out.println();
        
        System.out.println("中序遍历");
        mid(root);
        System.out.println();
        midRecursion(root);
        System.out.println();
        
        System.out.println("后序遍历");
        post(root);
        System.out.println();
        postRecursion(root);
        System.out.println();
        
        System.out.println("层序遍历");
        level(root);
    }

    private static TreeNode initBT() {
        
        /**
         *     1
         *   2   3
         * 4       5
         *        6
         *      7   8 
         */
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        
        t1.left = t2; t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t5.left = t6;
        t6.left = t7; t6.right = t8;
        return t1;
    }
    
}
