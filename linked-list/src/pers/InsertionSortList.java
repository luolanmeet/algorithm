package pers;

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @author cck
 */
public class InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        
        ListNode header = new ListNode(-1);
        while (head != null) {
            
            ListNode insertNode = head;
            head = head.next;
            if (header.next == null) { // 当前序列是空
                
                insertNode.next = null;
                header.next = insertNode;
            } else {
                
                ListNode p = header;
                // 查找应该插入的位置
                while (p.next != null && p.next.val < insertNode.val) {
                    p = p.next;
                }
                
                insertNode.next = p.next;
                p.next = insertNode;
            }
        }
        
        ListNode resNode = header.next;
        header.next = null;
        return resNode;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        
        InsertionSortList obj = new InsertionSortList();
        ListNode head = obj.insertionSortList(l1);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
        
    }
    
}
