package pers;
/**
 * 526. 优美的排列
 * https://leetcode-cn.com/problems/beautiful-arrangement/
 * @author cck
 */
public class CountArrangement {
    
    public int countArrangement(int N) {
        return method(N, new boolean[N + 1], 1);
    }
    
    /**
     * 主要是used这个数组的使用
     */
    private int method(int n, boolean[] used, int idx) {
    
        if (idx > n) return 1;
    
        int count = 0;
    
        for (int i = 1; i <= n; i++) {
        
            if (used[i]) continue;
        
            if (i % idx == 0 || idx % i == 0) {
                used[i] = true;
                count += method(n, used, idx + 1);
                used[i] = false;
            }
        }
    
        return count;
    }
    
    public static void main(String[] args) {
        CountArrangement obj = new CountArrangement();
        System.out.println(obj.countArrangement(2));
        System.out.println(obj.countArrangement(8));
    }
    
}
