package pers;

/**
 * 1079. 活字印刷
 * https://leetcode-cn.com/problems/letter-tile-possibilities/comments/
 *
 * 另一种解法：计算出全排列的数量，然后再除以每个重复的排列个数。
 * 例如"AAABBC"组成的6个字母的排列数为 A(6，6) / [A(3,3)*A(2,2)]。
 */
public class NumTilePossibilities {
    
    /**
     * 不直接用字符串的每个字符去回溯 而是先统计
     * 自带去重功能
     */
    public int numTilePossibilities(String tiles) {
    
        int[] counter = new int[26];
        
        for (int i = 0; i < tiles.length(); i++) {
            counter[tiles.charAt(i) - 'A']++;
        }
    
        return backtrack(counter);
    }
    
    private int backtrack(int[] counter) {
        
        int sum = 0;
        
        for (int i = 0; i < 26; i++) {
        
            if (counter[i] > 0) {
                sum++;
                counter[i]--;
                sum += backtrack(counter);
                counter[i]++;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        NumTilePossibilities obj = new NumTilePossibilities();
        System.out.println(obj.numTilePossibilities("AAB"));
        System.out.println(obj.numTilePossibilities("ABC"));
    }
    
}
