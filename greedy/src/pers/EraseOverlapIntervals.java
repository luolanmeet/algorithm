package pers;

import java.util.Arrays;

/**
 * 435. 无重叠区间 （和452很像）
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @author cck
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length <= 1) {
            return 0;
        }
        
        // 右区间升序排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0;
        int temp = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[i][0] < temp) {
                res++;
            } else {
                temp = intervals[i][1];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        EraseOverlapIntervals obj = new EraseOverlapIntervals();
        System.out.println(obj.eraseOverlapIntervals(new int[][] {
            {1,2},
            {2,3},
            {3,4},
            {1,3}
        }));
        
        System.out.println(obj.eraseOverlapIntervals(new int[][] {
            {1,2},
            {1,2},
            {1,2}
        }));
        
        System.out.println(obj.eraseOverlapIntervals(new int[][] {
            {1,2},
            {2,3}
        }));
        
    }
    
}
