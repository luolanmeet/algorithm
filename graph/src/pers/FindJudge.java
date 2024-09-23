package pers;

/**
 * 997. 找到小镇的法官
 * https://leetcode.cn/problems/find-the-town-judge/description/
 * @auther ken.ck
 * @date 2024/9/23 21:20
 */
public class FindJudge {

    public int findJudge(int n, int[][] trust) {
        // 节点的出度入度
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] edge : trust) {
            in[edge[1]]++;
            out[edge[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
