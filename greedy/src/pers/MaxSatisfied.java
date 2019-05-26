package pers;

/**
 * 1052. 爱生气的书店老板
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * @author cck
 */
public class MaxSatisfied {
    
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        int ncus = 0;
        int nbad = 0;
        int len = customers.length;
        
        for (int i = 0; i < len; i++) {
            
            ncus += customers[i];
            
            if (grumpy[i] == 1) {
                nbad += customers[i];
            } else {
                customers[i] = 0;
            }
        }

        int best = 0;
        int cur = 0;
        
        for (int i = 0; i < len; i++) {
            
            // 计算X分钟内能获取到的最大的满意数
            // 每次都加 i，然后每次都减去第 i - X，所以 cur一直都是X分钟内的数据
            cur += customers[i];
            if (i >= X) {
                cur -= customers[i - X];
            }
            best = Math.max(cur, best);
        }
        
        return ncus - (nbad - best);
    }
    
}
