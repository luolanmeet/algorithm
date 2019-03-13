package pers;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @author cck
 */
public class Flatten {
    
    public Node flatten(Node head) {
        
        if (head == null) {
            return head;
        }
        
        Node pre = new Node();
        flatten(head, pre);
        pre.next.prev = null;
        return pre.next;
    }

    private Node flatten(Node head, Node pre) {
        
        if (head == null) {
            return pre;
        }
        
        pre.next = head;
        head.prev = pre;
        pre = head;
        
        Node tempNext = head.next;
        
        if (head.child != null) {
            Node tempChild = head.child;
            head.child =  null;
            pre = flatten(tempChild, head);
        }
        
        if (head.next != null) {
            pre = flatten(tempNext, pre);
        }
        
        return pre;
    }
    
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
        
    public static void main(String[] args) {
        
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        Node n8 = new Node();
        
        /**
         * 1 2 3 4
         *     5 6 7
         *       8
         */
        
        n1.val = 1;
        n1.next = n2;
        n2.val = 2;
        n2.prev = n1;
        n2.next = n3;
        n3.val = 3;
        n3.prev = n2;
        n3.next = n4;
        n3.child = n5;
        n4.val = 4;
        n4.prev = n3;
        n5.val = 5;
        n6.val = 6;
        n5.next = n6;
        n6.next = n7;
        n7.val = 7;
        n6.child = n8;
        n8.val = 8;
        
        Flatten obj = new Flatten(); 
        Node node = obj.flatten(n1);
        
        while (node != null) {
            
            if (node.prev == null) {
                
                System.out.print("(null," + node.val + ") ");
            } else {
                
                System.out.print("("+ node.prev.val + "," + node.val + ") ");
            }
            
            node = node.next;
        }
        
    }
    
}
