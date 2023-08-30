package pers;

import java.util.Stack;

/**
 * 2390. 从字符串中移除星号
 * https://leetcode.cn/problems/removing-stars-from-a-string/
 * @auther ken.ck
 * @date 2023/8/30 11:42
 */
public class RemoveStars {

    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character c : stack) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        RemoveStars obj = new RemoveStars();
        System.out.println(obj.removeStars("leet**cod*e"));
    }

}
