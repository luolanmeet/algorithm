package pers.sword;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author cck
 */
public class Algorithm5 {

    // 用栈存储元素，然后再打印出来
    public void printLink(ListNode head) {
    
        Stack<Integer> stack = new Stack<>();
        
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
    
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    
    // 递归好一些
    public void printLink2(ListNode head) {
        if (head == null) return ;
        printLink2(head.next);
        System.out.println(head.val);
    }
    
    // 反转链表再打印
    public void printLink3(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        
        // 反转
        while (head != null) {
            next = head.next;
            head.next = pre;
            
            pre = head;
            head = next;
        }
     
        // 打印
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
    
        Algorithm5 obj = new Algorithm5();
        obj.printLink(l1);
        System.out.println();
        obj.printLink2(l1);
        System.out.println();
        obj.printLink3(l1);
    }
    
}
