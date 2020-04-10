package pers;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    /**
     *  String 的 split 方法， "a good   example"
     *  对空格进行分割，结果是[a, good, , , example]
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder();
        String[] strs = s.trim().split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            String tmp = strs[i].trim();
            if (!"".equals(tmp)) {
                res.append(tmp).append(" ");
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {

        ReverseWords obj = new ReverseWords();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("a good   example"));
    }

}
