package pers;

/**
 * 725. 分隔链表
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * @author cck
 */
public class SplitListToParts {
    
    public ListNode[] splitListToParts(ListNode root, int k) {
        
        // 先统计链表长度，然后计算每个链表的长度
        ListNode temp = root;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int[] lens = new int[k]; 
        for (int i = 0; i < len % k; i++) {
            lens[i] = 1;
        }
        
        ListNode[] resp = new ListNode[k];
        int count = len / k;
        for (int i = 0; i < k; i++) {
            
            resp[i] = root;
            for (int j = 1; j < count + lens[i]; j++) {
                root = root.next;
            }
            
            if (root != null) {
                temp = root.next;
                root.next = null;
                root = temp;
            }
        }
        
        return resp;
    }

    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;

        SplitListToParts obj = new SplitListToParts();
        ListNode[] resp = obj.splitListToParts(l1, 3);
        
        for (ListNode head : resp) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
    
}
