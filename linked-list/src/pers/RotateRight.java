package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * @author cck
 */
public class RotateRight {
    
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || k == 0) {
            return head;
        }
        
        List<ListNode> list = new ArrayList<>();
        
        ListNode temp;
        while (head != null) {
            list.add(head);
            temp = head.next;
            head.next = null;
            head = temp;
        }
        
        int size = list.size();
        
        k = k % size;
        
        ListNode resp = new ListNode(0);
        ListNode now = resp;
        
        int index = size - k;
        for (int i = 0; i < size; i++) {
            now.next = list.get((index + i) % size);
            now = now.next;
        }
        
        return resp.next;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        RotateRight obj = new RotateRight();
        ListNode head = obj.rotateRight(l1, 4);
        
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        
    }
    
}
