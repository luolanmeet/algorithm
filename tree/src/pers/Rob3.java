package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 * @auther ken.ck
 * @date 2021/2/10 22:52
 */
public class Rob3 {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root))
            return memo.get(root);

        // 取
        int res1 = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        // 不取
        int res2 = rob(root.left) + rob(root.right);

        memo.put(root, Math.max(res1, res2));

        return memo.get(root);
    }

}
