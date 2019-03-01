package pers;

/**
 * 链表的归并排序
 * @author cck
 */
public class MergeSort {

    /**
     * 归并排序
     * 1. 拆分链表（快慢指针）
     * 2. 合并有序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null; // 咬断链表
        
        return mergeList(sortList(head), sortList(right));
    }

    // 合并链表
    public ListNode mergeList(ListNode head1, ListNode head2)  {
        
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        
        ListNode head = head1.val <= head2.val ? head1 : head2;
        
        ListNode cur1 = head1 == head ? head1 : head2;
        ListNode cur2 = head1 == head ? head2 : head1;
        ListNode pre = null;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                pre = cur2;
                cur2.next = cur1;
                cur2 = next;
            }
        }
        
        pre.next = cur1 == null ? cur2 : cur1;
        
        return head;
    }

    /**
     * 快慢指针获取中点
     * @param head
     * @return
     */
    public ListNode getMid(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(56);
        ListNode l5 = new ListNode(156);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        MergeSort obj = new MergeSort();
        ListNode node = obj.sortList(l1);
        
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        
    }
    
}
