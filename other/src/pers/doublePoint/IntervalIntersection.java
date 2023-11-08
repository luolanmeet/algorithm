package pers.doublePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. 区间列表的交集
 * https://leetcode.cn/problems/interval-list-intersections/description/
 * @auther ken.ck
 * @date 2023/11/8 22:46
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            // 左端取最大
            int left = Math.max(firstList[i][0], secondList[j][0]);
            // 右端取最小
            int right = Math.min(firstList[i][1], secondList[j][1]);

            if (left <= right) {
                result.add(new int[]{left, right});
            }

            // 区间先结束，递增
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[0][0]);
    }

    public static void print(int[][] nums) {
        for (int[] num : nums) {
            System.out.print("[" + num[0] + "," + num[1] + "]" + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntervalIntersection obj = new IntervalIntersection();
        int[][] res = obj.intervalIntersection(
                new int[][]{{1,3},{5,9}},
                new int[][]{});
        print(res);
        res = obj.intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        print(res);
    }

}
