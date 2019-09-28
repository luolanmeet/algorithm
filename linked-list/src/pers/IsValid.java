package pers;

import java.util.Stack;

/**
 * 1003. 检查替换后的词是否有效
 * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
 */
public class IsValid {

    public boolean isValid(String S) {

        if (S == null || S.isEmpty()) {
            return true;
        }
        if (S.length() % 3 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] cs = S.toCharArray();

        for (char c : cs) {

            if (c == 'c') {

                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        IsValid obj = new IsValid();
        System.out.println(obj.isValid("abc"));
        System.out.println(obj.isValid("aabcbc"));
        System.out.println(obj.isValid("abcabc"));
        System.out.println(obj.isValid("abcabcababcc"));

        System.out.println();

        System.out.println(obj.isValid("cababc"));
        System.out.println(obj.isValid("aabbcc"));
        System.out.println(obj.isValid("abccba"));
    }

}
