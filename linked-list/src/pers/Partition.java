package pers;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * @author cck
 */
public class Partition {

    //给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
    //你应当保留两个分区中每个节点的初始相对位置。
    
    public ListNode partition(ListNode head, int x) {
        
        ListNode resp = new ListNode(0);
        resp.next = head;
        
        // pre 作为要移动的节点的上个节点
        ListNode insertPre = resp;
        while (insertPre.next != null && insertPre.next.val < x) {
            insertPre = insertPre.next;
        }
        
        head = insertPre.next;
        ListNode pre = head; 
        while (head != null) {
            
            if (head.val < x) {
                pre.next = head.next;
                head.next = insertPre.next;
                insertPre.next = head;
                insertPre = head;
                head = pre.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        
        return resp.next;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        
        Partition obj = new Partition();
        ListNode head = obj.partition(l1, 3);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
    
}
