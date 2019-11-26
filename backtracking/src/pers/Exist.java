package pers;
/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * 典型的回溯，注意用used表示是否使用过此字母
 */
public class Exist {

    public boolean exist(char[][] board, String word) {

        char[] cs = word.toCharArray();

        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (method(board, used, cs, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean method(char[][] board, boolean[][] used, char[] cs, int i, int j, int idx) {

        if (idx >= cs.length) return true;

        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length ||
                used[i][j] || board[i][j] != cs[idx]) {

            return false;
        }

        used[i][j] = true;

        // 四个方向查找
        if (method(board, used, cs, i + 1, j, idx + 1)) {
            return true;
        }
        if (method(board, used, cs, i - 1, j, idx + 1)) {
            return true;
        }
        if (method(board, used, cs, i, j + 1, idx + 1)) {
            return true;
        }
        if (method(board, used, cs, i, j - 1, idx + 1)) {
            return true;
        }

        used[i][j] = false;
        return false;
    }
    
    public static void main(String[] args) {
        Exist obj = new Exist();
        
        System.out.println(obj.exist(new char[][]{{'a'}}, "a"));
        System.out.println(obj.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
        System.out.println(obj.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "SEE"));
        System.out.println(obj.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
    }
    
}
