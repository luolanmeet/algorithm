package pers;

import java.util.Random;

/**
 * 在不知道序列长度的前提下，
 * 只用一次遍历就获取序列中随机一个元素，
 * 并且获取到每个元素的概率相等
 *
 * 原理：
 * 假设总共n个数，当前循环到第k个，k被选中的概率如下：
 *
 *  (1/k) * (k/k+1) * (k+1/k+2) * (k+2/k+3) *...* (n-1/n) = 1/n
 *  k被选中 * k不被替换 *...* k不被替换 = 1/n
 */
public class RandomElement {

    public ListNode getRandomElement(ListNode node) {

        if (node == null) {
            return null;
        }

        int countSoFar = 1;
        ListNode res = node;
        node = node.next;
        Random random = new Random();

        while (node != null) {
            countSoFar++;
            if (random.nextInt(countSoFar) == 0) {
                res = node;
            }
            node = node.next;
        }

        return res;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        RandomElement obj = new RandomElement();

        for (int i = 0; i < 100; i++) {
            System.out.println(obj.getRandomElement(n1));
        }
    }

}
