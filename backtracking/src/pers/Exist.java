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
                
                if (board[i][j] != cs[0]) {
                    continue;
                }
    
                used[i][j] = true;
                if (backtrack(board, cs, used, i, j, 1)) {
                    return true;
                }
                used[i][j] = false;
            }
        }
    
        return false;
    }
    
    private boolean backtrack(char[][] board, char[] cs, boolean[][] used, int i, int j, int index) {
    
        if (index >= cs.length) {
            return true;
        }
        
        // 从当前的四个方向找
        // 往上找
        if (i > 0 && !used[i-1][j] && board[i-1][j] == cs[index]) {
            used[i-1][j] = true;
            if (backtrack(board, cs, used, i-1, j, index+1)) {
                return true;
            }
            used[i-1][j] = false;
        }
        // 往下找
        if (i < board.length - 1 && !used[i+1][j] && board[i+1][j] == cs[index]) {
            used[i+1][j] = true;
            if (backtrack(board, cs, used, i+1, j, index+1)) {
                return true;
            }
            used[i+1][j] = false;
        }
        // 往左找
        if (j > 0 && !used[i][j-1] && board[i][j-1] == cs[index]) {
            used[i][j-1] = true;
            if (backtrack(board, cs, used, i, j-1, index+1)) {
                return true;
            }
            used[i][j-1] = false;
        }
        // 往右找
        if (j < board[0].length - 1 && !used[i][j+1] && board[i][j+1] == cs[index]) {
            used[i][j+1] = true;
            if (backtrack(board, cs, used, i, j+1, index+1)) {
                return true;
            }
            used[i][j+1] = false;
        }
        
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
