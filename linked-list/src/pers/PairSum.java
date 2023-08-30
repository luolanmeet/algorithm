package pers;

/**
 * 2130. 链表最大孪生和
 * https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/
 * @auther ken.ck
 * @date 2023/8/30 16:50
 */
public class PairSum {

    public int pairSum(ListNode head) {

        // 快慢指针 找 中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newLink = slow.next;
        slow.next = null;

        // 反转链表
        ListNode pre = null;
        ListNode next = null;
        while (newLink != null) {
            next = newLink.next;
            newLink.next = pre;
            pre = newLink;
            newLink = next;
        }

        // 计算最大和
        int res = 0;
        while (pre != null) {
            res = Math.max(res, head.val + pre.val);
            head = head.next;
            pre = pre.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        PairSum obj = new PairSum();
        System.out.println(obj.pairSum(l1));
    }

}
