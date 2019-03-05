package pers;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author cck
 */
public class SwapPairs {
    
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node1 = head;
        ListNode node2 = head.next;
        head = node2;
        
        ListNode temp;
        ListNode preNode = new ListNode(0);
        while (node1 != null && node2 != null) {
            
            temp = node2.next;
            node2.next = node1;
            node1.next = temp;
            
            preNode.next = node2;
            preNode = node1;
            
            if (node1.next == null || node2.next == null) {
                break;
            }
            
            temp = node1;
            node1 = node2.next.next;
            node2 = temp.next.next;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        SwapPairs obj = new SwapPairs();
        ListNode head = obj.swapPairs(l1);

        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
