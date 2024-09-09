package pers;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {

    /**
     * bfs
     * 把同一个岛的1都消去
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return ;

        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {

        NumIslands obj = new NumIslands();
        System.out.println(obj.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}}));

        System.out.println(obj.numIslands(new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}}));
    }

}
