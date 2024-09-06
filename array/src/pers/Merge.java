package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 * 使用辅助空间，会变得简单很多
 */
public class Merge {

    public int[][] merge3(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] pre = intervals[0];
        res.add(pre);
        for (int i = 0; i < intervals.length; i++) {

            // 包含
            if (pre[1] >= intervals[i][1]) {
                continue;
            }
            // 可合并
            if (pre[1] >= intervals[i][0]) {
                pre[1] = intervals[i][1];
                continue;
            }
            // 不重叠
            if (pre[1] < intervals[i][0]) {
                pre = intervals[i];
                res.add(pre);
                continue;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        // 排序
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {

            int size = result.size();

            // 第一个区间 或 新的区间的左区间大于已存在的最大右区间，则直接加入结果中
            if (size == 0 || result.get(size - 1)[1] < intervals[i][0]) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                // 区间出现重叠，取最大的区间值。
                result.get(size-1)[1] = Math.max(result.get(size-1)[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

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
        int[][] merge = obj.merge2(new int[][]{
                {1, 3},
                {2, 6},
                {2, 6},
                {15, 18},
                {8, 10},
        });
        sout(merge);
        merge = obj.merge2(new int[][]{
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
