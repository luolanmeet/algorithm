package pers;

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @author cck
 */
public class InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        ListNode resp = new ListNode(0);
        
        ListNode pre;
        ListNode temp;
        
        while (head != null) {
            
            pre = resp;
            temp = resp.next;
            
            while (temp != null && head.val > temp.val) {
                pre = temp;
                temp = temp.next;
            }
            
            // head是当前最大的，放入链表最后
            if (temp == null) {
                
                pre.next = head;
                head = head.next;
                pre.next.next = null;
                
            } else {
                
                // head 插入到pre 和 temp 中间
                pre.next = head.next;
                head.next = temp;
                temp = pre.next;
                pre.next = head;
                head = temp;
                
                /*ListNode temp2 = head.next;
                pre.next = head;
                head.next = temp;
                head = temp2;*/
            }
        }
        
        return resp.next;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        
        InsertionSortList obj = new InsertionSortList();
        ListNode head = obj.insertionSortList(l1);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
