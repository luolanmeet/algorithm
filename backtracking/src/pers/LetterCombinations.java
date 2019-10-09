package pers;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 都不用回溯
 */
public class LetterCombinations {
    
    static Map<Character, List<Character>> map = new HashMap<>();
    
    static {
        char tmp = 'a';
        for (char c = '2'; c <= '9'; c++) {
            if (c == '7' || c == '9') {
                map.put(c, Arrays.asList(tmp++, tmp++, tmp++, tmp++));
            } else {
                map.put(c, Arrays.asList(tmp++, tmp++, tmp++));
            }
        }
    }
    
    public List<String> letterCombinations(String digits) {
    
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
    
        backtrack(res, digits.toCharArray(), 0, "");
        return res;
    }
    
    private void backtrack(List<String> res, char[] cs, int i, String str) {
    
        if (str.length() == cs.length) {
            res.add(str);
            return ;
        }
    
        if (i >= cs.length) {
            return ;
        }
    
        for (Character c : map.get(cs[i])) {
            backtrack(res, cs, i + 1, str + c);
        }
    }
    
    public static void main(String[] args) {
    
        LetterCombinations obj = new LetterCombinations();
        System.out.println(obj.letterCombinations("7"));
        System.out.println(obj.letterCombinations("23"));
        System.out.println(obj.letterCombinations("234"));
    }
    
}
