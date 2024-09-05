package pers.doublePoint.slidingWindow;

/**
 * 2024. 考试的最大困扰度
 * https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/
 * @auther ken.ck
 * @date 2024/9/2 17:01
 */
public class MaxConsecutiveAnswers {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, 'T', k), maxConsecutiveChar(answerKey, 'F', k));
    }

    public int maxConsecutiveChar(String answerKey, char c, int k) {

        int res = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < answerKey.length()) {

            if (answerKey.charAt(right) == c) {
                right++;
                res = Math.max(res, right - left);
                continue;
            }

            if (k > sum) {
                sum++;
                right++;
                res = Math.max(res, right - left);
                continue;
            }

            while (k <= sum) {
                if (answerKey.charAt(left) == c) {
                    left++;
                    continue;
                }
                left++;
                sum--;
                break;
            }
        }

        return res;
    }


    /**
     * 暴力解法
     */
    int res = 0;
    public int maxConsecutiveAnswers2(String answerKey, int k) {
        backTrack(answerKey.toCharArray(), 0, k);
        return res;
    }

    public void backTrack(char[] cs, int idx, int k) {
        if (idx >= cs.length) {
            return ;
        }

        res = Math.max(res, getMaxLen(cs));

        if (k > 0) {

            char c = cs[idx];
            cs[idx] = c == 'T' ? 'F' : 'T';
            res = Math.max(res, getMaxLen(cs));
            backTrack(cs, idx + 1, k - 1);

            cs[idx] = c;
            backTrack(cs, idx + 1, k);
        }
    }

    public int getMaxLen(char[] cs) {
        int res = 1;
        int pre = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[pre] == cs[i]) {
                res = Math.max(res, i - pre + 1);
                continue;
            }
            pre = i;
        }
        return res;
    }


    public static void main(String[] args) {
        MaxConsecutiveAnswers obj = new MaxConsecutiveAnswers();
        System.out.println(obj.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(obj.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

}
