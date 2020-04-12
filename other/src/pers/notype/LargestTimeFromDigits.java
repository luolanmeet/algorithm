package pers.notype;

/**
 * https://leetcode-cn.com/problems/largest-time-for-given-digits/
 * 949. 给定数字能组成的最大时间
 */
public class LargestTimeFromDigits {

    public String largestTimeFromDigits(int[] A) {

        // 暴力破解
        int res = -1;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (i == j) continue;

                for (int m = 0; m < 4; m++) {

                    if (m == i || m == j) continue;

                    // 剩下的那个数的索引
                    int n = 6 - i - j - m;

                    if (A[i] * 10 + A[j] >= 24) continue;
                    if (A[m] * 10 + A[n] >= 60) continue;
                    res = Math.max(res, Integer.parseInt("" + A[i] + A[j] + A[m] + A[n]));
                }
            }
        }

        if (res == -1) return "";
        return String.format("%02d:%02d", res / 100, res % 100);
    }

    public static void main(String[] args) {
        LargestTimeFromDigits obj = new LargestTimeFromDigits();
        System.out.println(obj.largestTimeFromDigits(new int[]{2,0,6,6}));
    }

}
