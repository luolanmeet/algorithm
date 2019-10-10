package pers;
/**
 * 526. 优美的排列
 * https://leetcode-cn.com/problems/beautiful-arrangement/submissions/
 * @author cck
 */
public class CountArrangement {
    
    public int countArrangement(int N) {
        return backtrack(N, new boolean[N + 1], 0, 1);
    }
    
    /**
     * 主要是used这个数组的使用
     */
    private int backtrack(int n, boolean[] used, int count, int index) {
        
        if (index > n) {
            return count + 1;
        }

        for (int i = 1; i <= n; i++) {

            if (used[i]) {
                continue;
            }
            
            if (index % i == 0 || i % index == 0) {
                used[i] = true;
                count = backtrack(n, used, count, index + 1);
                used[i] = false;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        CountArrangement obj = new CountArrangement();
        System.out.println(obj.countArrangement(2));
    }
    
}
