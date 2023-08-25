package pers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 2352. 相等行列对
 * https://leetcode.cn/problems/equal-row-and-column-pairs/
 * @auther ken.ck
 * @date 2023/8/25 15:21
 */
public class EqualPairs {

    public int equalPairs(int[][] grid) {

        Map<String, Integer> row = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();

        int len = grid.length;

        for (int i = 0; i < len; i++) {
            StringJoiner temRow = new StringJoiner(";");
            StringJoiner temCol = new StringJoiner(";");
            for (int j = 0; j < len; j++) {
                temRow.add(grid[j][i] + "");
                temCol.add(grid[i][j] + "");
            }
            String tmp = temRow.toString();
            row.put(tmp, row.getOrDefault(tmp, 0) + 1);
            tmp = temCol.toString();
            col.put(tmp, col.getOrDefault(tmp, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : row.entrySet()) {
            res += col.getOrDefault(entry.getKey(), 0) * entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        EqualPairs obj = new EqualPairs();
        System.out.println(obj.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(obj.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }

}
