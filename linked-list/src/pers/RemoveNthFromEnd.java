package pers;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author cck
 */
public class RemoveNthFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode first = head;
        ListNode second = head;
        
        int m = n;
        int size = 0;
        while (first != null && m-- >= 0) {
            size++;
            first = first.next;
        }
        
        // 一共n个节点，删除倒数第n个的情况
        if (n == size) {
            return head.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // 删除
        if (second.next != null) {
            second.next = second.next.next;
        }
        
        return head;
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
        
        RemoveNthFromEnd obj = new RemoveNthFromEnd();
        ListNode head = obj.removeNthFromEnd(l1, 3);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
