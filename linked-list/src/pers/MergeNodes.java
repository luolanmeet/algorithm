package pers;

/**
 * 2181. 合并零之间的节点
 * https://leetcode.cn/problems/merge-nodes-in-between-zeros/description/
 * @auther ken.ck
 * @date 2024/9/9 15:59
 */
public class MergeNodes {

    public ListNode mergeNodes(ListNode head) {

        ListNode res = new ListNode(0);
        ListNode resTmp = res;
        ListNode zeroNode = null;

        // 模拟
        while (head != null) {
            if (head.val == 0 && zeroNode == null) {
                zeroNode = head;
            } else if (head.val != 0 && zeroNode == null) {
                resTmp.next = new ListNode(head.val);
                resTmp = resTmp.next;
            } else if (head.val == 0 && zeroNode != null) {
                // 取和
                int sum = 0;
                while (zeroNode != head) {
                    sum += zeroNode.val;
                    zeroNode = zeroNode.next;
                }
                zeroNode = head;
                resTmp.next = new ListNode(sum);
                resTmp = resTmp.next;
            }
            head = head.next;
        }

        return res.next;
    }

}
