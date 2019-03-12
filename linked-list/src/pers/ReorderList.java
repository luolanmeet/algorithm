package pers;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * @author cck
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        
        if (head == null) {
            return ;
        }
        
        // 找到链表的中点，切点链表，反转后边的链表，将后边的链表插入到前一个链表中
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        // 切断
        slow.next = null;
        
        // 反转链表
        ListNode pre = null;
        ListNode next;
        
        while (right != null) {
            
            next = right.next;
            right.next = pre;
            pre = right;
            right = next;
        }
        right = pre;
        
        // 将right插入到前边的链表中
        
        while (right != null) {
            next = head.next;
            head.next = right;
            right = right.next;
            head.next.next = next;
            head = next;
        }
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
        
        ReorderList obj = new ReorderList();
        obj.reorderList(l1);
        
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
        
    }
    
}
