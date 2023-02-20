package pers;

import java.util.Arrays;

/**
 * 2347. 最好的扑克手牌
 * https://leetcode.cn/problems/best-poker-hand/description/
 * @auther ken.ck
 * @date 2023/2/20 21:42
 */
public class BestHand {

    public String bestHand(int[] ranks, char[] suits) {

        // 也可以放Set里边，然后看 Set 的 size 即可
        if (suits[0] == suits[1]
                && suits[1] == suits[2]
                && suits[2] == suits[3]
                && suits[3] == suits[4]) {
            return "Flush";
        }

        Arrays.sort(ranks);
        int pre = ranks[0];
        int sameCount = 1;
        int maxSameCount = 1;
        for (int i = 1; i < 5; i++) {
            if (pre == ranks[i]) {
                sameCount++;
                continue;
            }
            maxSameCount = Math.max(sameCount, maxSameCount);
            sameCount = 1;
            pre = ranks[i];
        }

        maxSameCount = Math.max(sameCount, maxSameCount);

        return maxSameCount >= 3 ? "Three of a Kind" : maxSameCount == 2 ? "Pair" : "High Card";
    }

    public static void main(String[] args) {

        // 简单题
        BestHand obj = new BestHand();
        System.out.println(obj.bestHand(new int[]{13,2,3,1,9}, new char[]{'a','a','a','a','a'}));
        System.out.println(obj.bestHand(new int[]{4,4,2,4,4}, new char[]{'d','a','a','b','c'}));
    }

}
