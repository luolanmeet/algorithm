package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 * @author cck
 */
public class NextLargerNodes {
    
    public int[] nextLargerNodes(ListNode head) {
     
        // 直接转成数组处理
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 从后往前判断
        int[] res = new int[list.size()];
        res[list.size() - 1] = 0;
        TAG:for (int i = list.size() - 2; i >= 0; i--) {
    
            Integer now = list.get(i);
            
            // 上一个比当前的数值大
            if (now < list.get(i + 1)) {
                res[i] = list.get(i + 1);
                continue;
            }
            
            // 上一个比当前数值小，且往后的值都没有比上一个数值大的
            if (res[i + 1] == 0) {
                res[i] = 0;
                continue ;
            }
            
            // 遍历往后的数组
            for (int j = i + 2; j < list.size(); j++) {
                
                if (now < list.get(j)) {
                    res[i] = list.get(j);
                    continue TAG;
                }
                
                if (res[j] == 0) {
                    res[i] = 0;
                    continue TAG;
                }
            }
            
            res[i] = 0;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    
        NextLargerNodes obj = new NextLargerNodes();
    
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(Arrays.toString(obj.nextLargerNodes(n1)));
    }
    
}
