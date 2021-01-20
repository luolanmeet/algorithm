package pers;

/**
 * 4键键盘
 * @author cck
 * @date 2021/1/20 22:35
 */
public class MaxA {

    public int maxA(int N) {

        // 要想有最多的A，必定最后的操作是 按A 或 按CC+CV

        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <=N; i++) {

            // 这次按A
            dp[i] = dp[i-1] + 1;
            // 全选并复制dp[i-2] 连续粘贴i-j次
            // 屏幕上共dp[j-2] * [i-j+1]个A
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j-2] * (i-j+1));
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        MaxA obj = new MaxA();
        System.out.println(obj.maxA(10));
    }

}
