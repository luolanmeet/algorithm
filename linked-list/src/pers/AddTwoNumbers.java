package pers;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author cck
 */
public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode(0);
        ListNode temp = res;
        
        int add = 0;
        while (l1 != null || l2 != null) {
            
            int a = add;
            
            if (l1 != null) {
                a += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                a += l2.val;
                l2 = l2.next;
            }
            
            add = a / 10;
            a %= 10;
            temp.next = new ListNode(a);
            temp = temp.next;
        }
        
        if (add != 0) {
            temp.next = new ListNode(add);
        }
        
        return res.next;
    }
    
    public static void main(String[] args) {
        
        ListNode la1 = new ListNode(2);
        ListNode la2 = new ListNode(4);
        ListNode la3 = new ListNode(3);
        la1.next = la2;
        la2.next = la3;
        
        ListNode lb1 = new ListNode(5);
        ListNode lb2 = new ListNode(6);
        ListNode lb3 = new ListNode(4);
        lb1.next = lb2;
        lb2.next = lb3;
        
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode node = obj.addTwoNumbers(la1, lb1);
        
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    
}
