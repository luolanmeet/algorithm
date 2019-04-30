package pers;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author cck
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        
        if (points.length <= 1) {
            return points.length;
        }
        
        // 参考了网上的大佬
        // 其实就是找重叠
        // 先按照右端点升序排序, 然后每次从最小的右端点射出一支箭, 去掉被射爆的气球, 重复该过程. 
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
        int res = 1;
        int temp = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            
            if (points[i][0] > temp) {
                res++;
                temp = points[i][1];
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        
        FindMinArrowShots obj = new FindMinArrowShots();
        System.out.println(obj.findMinArrowShots(new int[][] {{10,16}, {2,8}, {1,6}, {7,12}}));
    }
    
}
