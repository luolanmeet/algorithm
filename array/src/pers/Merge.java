package pers;

import java.util.Arrays;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 * 使用辅助空间，会变得简单很多
 */
public class Merge {
    
    public int[][] merge(int[][] intervals) {
    
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        boolean[] need = new boolean[intervals.length];
        need[0] = true;
        int count = 1;
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (pre[1] >= intervals[i][0]) {
                if (pre[1] < intervals[i][1]) {
                    pre[1] =  intervals[i][1];
                }
            } else {
                pre = intervals[i];
                need[i] = true;
                count++;
            }
        }
        
        int[][] res = new int[count][2];
        for (int i = 0, j = 0; i < count && j < intervals.length; j++) {
            if (need[j]) {
                res[i++] = intervals[j];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    
        Merge obj = new Merge();
        int[][] merge = obj.merge(new int[][]{
                {1, 3},
                {2, 6},
                {2, 6},
                {15, 18},
                {8, 10},
        });
        sout(merge);
        merge = obj.merge(new int[][]{
                {1, 4},
                {2, 3},
        });
        sout(merge);
    }
    
    private static void sout(int[][] merge) {
        for (int[] tmp : merge) {
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println();
    }
    
}
