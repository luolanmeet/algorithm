package pers;

import java.util.Stack;

/**
 * 901. 股票价格跨度
 * https://leetcode-cn.com/problems/online-stock-span/
 * @author cck
 */
public class StockSpanner {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        
        if (s1.isEmpty()) {
            s1.push(price);
            s2.push(1);
            return 1;
        }
        
        if (price < s1.peek()) {
            s1.push(price);
            s2.push(1);
            return 1;
        }
        
        int res = 1;
        while (!s1.isEmpty() && s1.peek() <= price) {
            s1.pop();
            res += s2.pop();
        }
        
        s1.push(price);
        s2.push(res);
        
        return res;
    }
    
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
    
}
