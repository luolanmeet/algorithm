package pers;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author cck
 */
public class MergeTwoLists {
    
    /*
     * 递归的方式
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        
        return head;
    }
    
    /**
     * 非递归的方式
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        // 合并到第一个节点值小的那个链表上
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode cur1 = head == l1 ? l1 : l2;
        ListNode cur2 = head == l1 ? l2 : l1;
        
        ListNode pre = null; // cur1的前一个元素
        ListNode next = null; // cur2的后一个元素
        
        while (cur1 != null && cur2 != null) {
            
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                
                // cur2的节点插入到cur1所在的链表上
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
    
}
