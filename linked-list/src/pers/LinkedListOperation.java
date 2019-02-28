package pers;

public class LinkedListOperation {
    
    /**
     * 删除节点
     * 将要删除的节点的下一个节点的值赋予要删除的节点，然后删除要删除的节点的下个节点
     * 可以避免保存上个节点的操作
     * @param head
     * @param q
     */
    public void del(ListNode head, ListNode q) {
        
        if (q.next != null) {
            
            q.val = q.next.val;
            q.next = q.next.next;
            return ;
        }
        
        while (head != null) {
            
            if (head.next == q) {
                head.next = null;
                return ;
            }
            head = head.next;
        }
    }
    
    /**
     * 快慢指针
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
    
}
