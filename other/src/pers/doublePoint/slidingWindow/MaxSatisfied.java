package pers.doublePoint.slidingWindow;

/**
 * 1052. 爱生气的书店老板
 * https://leetcode.cn/problems/grumpy-bookstore-owner/description/
 * @auther ken.ck
 * @date 2024/4/24 10:22
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
        }
        if (minutes <= 0) {
            return res;
        }

        int tmpCount = 0;
        for (int i = 0; i < minutes; i++) {
            tmpCount += customers[i];
        }
        int max = tmpCount;
        for (int i = minutes; i < len; i++) {
            tmpCount += customers[i];
            tmpCount -= customers[i - minutes];
            max = Math.max(tmpCount, max);
        }

        return res + max;
    }

}
