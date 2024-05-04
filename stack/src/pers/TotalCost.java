package pers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2462. 雇佣 K 位工人的总代价
 * https://leetcode.cn/problems/total-cost-to-hire-k-workers/description/
 * @auther ken.ck
 * @date 2024/5/1 15:14
 */
public class TotalCost {

    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        double total = 0;
        for (int tmp : salary) {
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
            total += tmp;
        }
        return (total - min - max) / (double) (salary.length - 2);
    }

    /**
     * 排序堆
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public long totalCost(int[] costs, int k, int candidates) {

        int len = costs.length;
        long res = 0L;
        if (candidates * 2 + k > len) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }

        PriorityQueue<Integer> lq = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            lq.offer(costs[i]);
            rq.offer(costs[len - i - 1]);
        }
        int lidx = candidates;
        int ridx = len - candidates - 1;
        while (k > 0) {
            if (lq.peek() > rq.peek()) {
                res += rq.poll();
                rq.offer(costs[ridx]);
                ridx--;
            } else {
                res += lq.poll();
                lq.offer(costs[lidx]);
                lidx++;
            }
            k--;
        }

        return res;
    }

    /**
     * 模拟
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public long totalCost2(int[] costs, int k, int candidates) {

        int len = costs.length;
        long res = 0L;
        int lc = candidates;
        int rc = candidates;

        while (k > 0) {
            long tmpL = Long.MAX_VALUE;
            int tmpLIndex = 0;
            for (int i = 0; i < lc; i++) {
                if (costs[i] != -1 && costs[i] < tmpL) {
                    tmpL = costs[i];
                    tmpLIndex = i;
                }
            }
            long tmpR = Long.MAX_VALUE;
            int tmpRIndex = 0;
            for (int i = 0; i < rc; i++) {
                int tmpIndex = len - i - 1;
                if (costs[tmpIndex] != -1 && costs[tmpIndex] < tmpR) {
                    tmpR = costs[tmpIndex];
                    tmpRIndex = tmpIndex;
                }
            }

            if (tmpL > tmpR) {
                res += costs[tmpRIndex];
                costs[tmpRIndex] = -1;
                rc++;
            } else {
                res += costs[tmpLIndex];
                costs[tmpLIndex] = -1;
                lc++;
            }

            // 防止溢出
            if (lc + rc > len) {
                lc = len;
                rc = 0;
            }
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
        TotalCost obj = new TotalCost();
        System.out.println(obj.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println(obj.totalCost(new int[]{1,2,4,1}, 3, 3));
    }

}
