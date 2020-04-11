package pers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 539. 最小时间差
 * https://leetcode-cn.com/problems/minimum-time-difference/
 */
public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {

        List<Integer> collect = timePoints.stream().map(s -> {
            String[] strs = s.split(":");
            return Integer.parseInt(strs[0] + strs[1]);
        }).collect(Collectors.toList());

        Collections.sort(collect);

        int len = collect.size() - 1;
        int min = getBetMin2(collect.get(0), collect.get(len));

        for (int i = 1; i <= len; i++) {
            min = Math.min(min, getBetMin(collect.get(i - 1), collect.get(i)));
        }

        return min;
    }

    /**
     * 计算第一个时间到第二个时间的间隔
     * @param one
     * @param two
     * @return
     */
    private int getBetMin(Integer one, Integer two) {
        return (two / 100 - one / 100) * 60 + (two % 100 - one % 100);
    }

    /**
     * 计算今天的最晚时间到明天的最早时间的间隔
     * @param one
     * @param two
     * @return
     */
    private int getBetMin2(Integer one, Integer two) {
        return (24 - two / 100 + one / 100) * 60 - two % 100 + one % 100;
    }

    public static void main(String[] args) {
        FindMinDifference obj = new FindMinDifference();
        System.out.println(obj.findMinDifference(Arrays.asList("23:59","00:00")));
        System.out.println(obj.findMinDifference(Arrays.asList("22:59","21:59","22:50","18:59","00:00")));
    }

}
