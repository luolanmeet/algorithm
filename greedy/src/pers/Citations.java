package pers;

import java.util.Arrays;

/**
 * 274. H 指数
 * https://leetcode.cn/problems/h-index/description/
 * @auther ken.ck
 * @date 2024/9/9 16:11
 */
public class Citations {

    public int hIndex(int[] citations) {

        // 从小到大排序
        Arrays.sort(citations);

        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i) {
                return len - i;
            }
        }

        return 0;
    }

}
