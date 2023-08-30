package pers;

/**
 * 2095. 删除链表的中间节点
 * https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/
 * @auther ken.ck
 * @date 2023/8/30 14:45
 */
public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 因为要移除中间的节点，所以还要持有中间节点的前一个节点
        ListNode preSlow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

        if (fast.next == null) {
            // 节点总数为奇数的情况，slow 正好是中点，在 3 的位置
            // 1 2 3 4 5
            preSlow.next = slow.next;
        } else {
            // 节点总数为偶数的情况，slow 是偏左的节点，在 2 的位置
            // 1 2 3 4
            slow.next = slow.next.next;
        }

        return head;
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

        DeleteMiddle obj = new DeleteMiddle();
        ListNode head = obj.deleteMiddle(l1);

        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }

    }

}
