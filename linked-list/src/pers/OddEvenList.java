package pers;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * @author cck
 */
public class OddEvenList {
    
    public ListNode oddEvenList(ListNode head) {
        
        ListNode resp = head;
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode tempH2 = h2;
        
        boolean isOdd = true;
        while (head != null) {
            
            if (isOdd) {
                h1.next = head;
                head = head.next;
                h1.next.next = null;
                h1 = h1.next;
            } else {
                h2.next = head;
                head = head.next;
                h2.next.next = null;
                h2 = h2.next;
            }
            isOdd = !isOdd;
        }
        
        h1.next = tempH2.next;
        
        return resp;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        
        OddEvenList obj = new OddEvenList();
        ListNode head = obj.oddEvenList(l1);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    
}
