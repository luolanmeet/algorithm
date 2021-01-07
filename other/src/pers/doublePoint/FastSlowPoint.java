package pers.doublePoint;

import pers.ListNode;

/**
 * 快慢指针
 *  求链表是否有闭环
 *  求链表的闭环的起点
 *  求链表的中点/倒数第几个节点
 * @author cck
 * @date 2021/1/7 8:30
 */
public class FastSlowPoint {

    /**
     * 判断链表是否存在环
     * @param node
     * @return
     */
    public boolean hasCycle(ListNode node) {

        ListNode fast = node, slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 获取链表的中点
     * @param node
     * @return
     */
    public ListNode getMidNode(ListNode node) {

        // 假设链表长度为m
        // 如果m是奇数，最终会返回中点
        // 如果m是偶数，会返回靠右边的中点

        // 因为一开始快慢节点都赋值了初始节点，剩余可以走的节点数就是 n = m-1，奇偶互换
        // 在【如果还有下一个节点，就可以继续走】的判断条件下【fast != null && fast.next != null】
        // 剩余3个节点和剩余4个节点能走的次数是一样的。所以对于n是奇数的情况，最终slow节点会和n+1个节点的链表
        // 前进的步数是一样的，前者会位于中点，后者自然是靠右边的中点。
        ListNode fast = node, slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        FastSlowPoint obj = new FastSlowPoint();

//        l4.next = l1;
        System.out.println(obj.hasCycle(l1));

//        l4.next = new ListNode(5);
        System.out.println(obj.getMidNode(l1));
    }

}
