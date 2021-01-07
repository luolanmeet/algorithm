package pers;

public class ListNode {
    
    int val;
    public ListNode next;
    
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return this.val +  "";
    }
}
