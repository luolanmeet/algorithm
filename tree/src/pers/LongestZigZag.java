package pers;

/**
 * 1372. 二叉树中的最长交错路径
 * https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/
 * @auther ken.ck
 * @date 2023/8/30 17:57
 */
public class LongestZigZag {

    int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxLen = 0;
        dfs(root.left, false, 0);
        dfs(root.right, true, 0);
        return maxLen;
    }

    private void dfs(TreeNode node, boolean toLeft, int len) {
        maxLen = Math.max(maxLen, len);
        if (node == null) {
            return ;
        }
        if (toLeft) {
            dfs(node.left, false, len + 1);
            dfs(node.right, true, 0);
        } else {
            dfs(node.left, false, 0);
            dfs(node.right, true, len + 1);
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t4.left = t5;
        t4.right = t6;
        t5.right = t7;

        LongestZigZag obj = new LongestZigZag();
        System.out.println(obj.longestZigZag(t1));
    }

}
