package pers.doublePoint;

/**
 * 809. 情感丰富的文字
 * https://leetcode.cn/problems/expressive-words/description/
 *
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
 * 扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 *
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo"
 * 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。
 * 如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得
 * query = "hello" -> "hellooo" -> "helllllooo" = s。
 *
 * @auther ken.ck
 * @date 2022/11/26 21:20
 */
public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {

        int res = 0;
        char[] sc = s.toCharArray();
        for (String word : words) {

            if (word.length() > s.length()) {
                continue;
            }

            int idx = 0;
            int p1 = 0;
            int p2 = 0;
            char[] wc = word.toCharArray();
            boolean isMatch = true;
            // 双指针
            while ((idx = p1) < sc.length && p2 < wc.length) {

                // 统计字符 sc[idx] 在字符串中连续出现的次数
                int c1 = 0;
                int c2 = 0;
                while (p1 < sc.length && sc[p1] == sc[idx]) {
                    p1++;
                    c1++;
                }
                while (p2 < wc.length && wc[p2] == sc[idx]) {
                    p2++;
                    c2++;
                }

                if ((c1 != c2 && c1 < 3) || (c1 < c2 && c2 > 3)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch && p1 == sc.length && p2 == wc.length) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ExpressiveWords obj = new ExpressiveWords();
        System.out.println(obj.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(obj.expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"}));
    }

}
