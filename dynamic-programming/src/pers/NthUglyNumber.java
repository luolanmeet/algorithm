package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 264. 丑数 II
 * https://leetcode-cn.com/problems/ugly-number-ii/submissions/
 * @author cck
 */
public class NthUglyNumber {
    
    public int nthUglyNumber(int n) {

        if (n == 1) {
            return 1;
        }
        
        int i1 = 0, i2 = 0, i3 = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        for (int i = 1; i < n; i++) {
            
            int t1 = list.get(i1) * 2;
            int t2 = list.get(i2) * 3;
            int t3 = list.get(i3) * 5;
            
            int t = Math.min(Math.min(t1, t2), t3);
            
            list.add(t);
            
            if (t1 == t) {
                i1++;
            }
            if (t2 == t) {
                i2++;
            }
            if (t3 == t) {
                i3++;
            }
        }
        
        return list.get(n - 1);
    }
    
    public static void main(String[] args) {
        NthUglyNumber obj = new NthUglyNumber();
        System.out.println(obj.nthUglyNumber(10));
    }
    
}
