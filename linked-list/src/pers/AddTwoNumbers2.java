package pers;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @author cck
 */
public class AddTwoNumbers2 {
    
    /**
     * 相比两数相加 Ⅰ 
     * 这道题的加数的数字在链表中是顺序排列的
     * 可考虑 反转链表，直接变成 两数相加 Ⅰ 一样的情况，得到结果后再次反转链表
     * 这里采用栈的方式，其实也是类似与反转链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode node = null;
        
        while (!s1.isEmpty() || !s2.isEmpty() || !s3.isEmpty()) {
            
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s2.isEmpty() ? 0 : s2.pop().val;
            int c = s3.isEmpty() ? 0 : s3.pop();
            
            int sum = a + b + c;
            
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
            
            sum /= 10;
            
            if (sum != 0) {
                s3.push(sum);
            }
        }
        
        return node;
    }
    
    public static void main(String[] args) {
        
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(9);
        ListNode a5 = new ListNode(9);
        ListNode a6 = new ListNode(9);
        ListNode a7 = new ListNode(9);
        ListNode a8 = new ListNode(9);
        ListNode a9 = new ListNode(9);
        ListNode a10 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a8;
        a8.next = a9;
        a9.next = a10;
        ListNode b1 = new ListNode(7);
        
        AddTwoNumbers2 obj = new AddTwoNumbers2();
        ListNode head = obj.addTwoNumbers(a1, b1);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
