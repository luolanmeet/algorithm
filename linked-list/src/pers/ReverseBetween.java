package pers;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author cck
 */
public class ReverseBetween {

    // 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode resp = new ListNode(0);
        resp.next = head;
        
        ListNode left = resp;
        for (int i = 1; i < m; i++) {
            left = left.next;
        }
        
        head = left.next;
        ListNode first = head;
        ListNode next;
        ListNode pre = null;
        for (int i = 0; i < n - m + 1; i++) {
            
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        left.next = pre;
        first.next = head;
        
        return resp.next;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        ReverseBetween obj = new ReverseBetween();
        ListNode head = obj.reverseBetween(l1, 2, 4);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
