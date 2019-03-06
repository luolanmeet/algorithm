package pers;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author cck
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null) {
            return null;
        }
        
        // 用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow != fast) {
                continue;
            }
            
            while (head != fast) {
                head = head.next;
                fast = fast.next;
            }
            return head;
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l4.next = l2;
        
        DetectCycle obj = new DetectCycle();
        ListNode head = obj.detectCycle(l1);
        System.out.println(head.val);
    }
    
}
