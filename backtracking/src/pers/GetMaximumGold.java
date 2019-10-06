package pers;

/**
 *  5215. 黄金矿工
 *  https://leetcode-cn.com/contest/weekly-contest-157/problems/path-with-maximum-gold/
 */
public class GetMaximumGold {

    static int dr[] = new int[]{0, -1, 0, 1};
    static int dc[] = new int[]{-1, 0, 1, 0};
    int res = 0;

    public int getMaximumGold(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(i, j, grid, new boolean[grid.length][grid[0].length], 0);
            }
        }

        return res;
    }

    public void dfs(int a, int b, int[][] grid, boolean[][] bs, int val) {

        if (a < 0 || b < 0 || a >= grid.length || b >= grid[0].length || grid[a][b] == 0 || bs[a][b])
            return ;

        res = Math.max(res, val + grid[a][b]);
        bs[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int na = a + dr[i];
            int nb = b + dc[i];
            dfs(na, nb, grid, bs, val + grid[a][b]);
        }
        bs[a][b] = false;
    }

    public static void main(String[] args) {

        GetMaximumGold obj = new GetMaximumGold();
//        System.out.println(obj.getMaximumGold(new int[][]{{0,6,0}, {5,8,7}, {0,9,0}}));
        System.out.println(obj.getMaximumGold(new int[][]{{1,0,7}, {2,0,6}, {3,4,5}, {0,3,0}, {9,0,20}}));

    }

}
