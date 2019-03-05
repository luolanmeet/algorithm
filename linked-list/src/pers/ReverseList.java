package pers;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author cck
 */
public class ReverseList {
    
    public ListNode reverseList(ListNode head) {
        
        ListNode pre = null;
        ListNode next = null;
        
        while (head != null) {
            
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        
        ReverseList obj = new ReverseList();
        ListNode node = obj.reverseList(l1);
        
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    
}
