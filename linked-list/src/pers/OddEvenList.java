package pers;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * @author cck
 */
public class OddEvenList {
    
    public ListNode oddEvenList(ListNode head) {
        
        // 拆成两个链表
        
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
        
        
        return h1.next;
    }
    
}
