package pers.fun;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 289. 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 */
public class GameOfLife {

    private static final int[] x = {0,  0,  1, 1, 1, -1, -1, -1};
    private static final int[] y = {-1, 1, -1, 0, 1, -1,  0,  1};

    /**
     * 更新原数组
     * 2 表示以前活着，下次死了
     * -1 表示以前死了，下次活了
     */
    private static void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                int count = 0;
                for (int k = 0; k < x.length; k++) {

                    int a = i + x[k];
                    int b = j + y[k];
                    if (a < 0 || b < 0 || a >= board.length || b >= board[0].length) {
                        continue;
                    }
                    if (board[a][b] > 0) {
                        count++;
                    }
                }

                if (board[i][j] == 1) {
                    if (count != 2 && count != 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private static final String[] col = new String[]{"□", "■"};
    public static void printArray(int[][] board) {

        System.out.println();
        System.out.println();

        for (int[] tmp : board) {
            Arrays.stream(tmp).forEach(val -> System.out.print(col[val]));
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int[][] board = {
                {1,0,1,0,1,0},
                {0,1,0,1,1,0},
                {1,1,0,1,1,0},
                {0,1,0,0,1,0},
                {0,1,0,1,1,0}
        };

        for (int i = 0; i < 10; i++) {
            printArray(board);
            gameOfLife(board);
            TimeUnit.SECONDS.sleep(3);
        }

    }

}
