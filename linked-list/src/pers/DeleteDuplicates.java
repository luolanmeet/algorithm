package pers;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/ 
 * @author cck
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) {
            return head;
        }

        int preVal = 0;
        if (head.val == Integer.MAX_VALUE) {
            preVal = head.val - 1;
        } else if (head.val == Integer.MIN_VALUE) {
            preVal = head.val + 1;
        } else {
            preVal = head.val + 1;
        }
        
        ListNode preNode = new ListNode(preVal);
        ListNode resp = preNode;
        preNode.next = head;
        
        while (head != null && head.next != null) {
            
            if (head.val == head.next.val) {
                
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
                preNode.next = head;
            } else {
                
                preVal = head.val;
                preNode = head;
                head = head.next;
            }
        }
        
        return resp.next;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        DeleteDuplicates obj = new DeleteDuplicates();
        ListNode head = obj.deleteDuplicates(l1);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
