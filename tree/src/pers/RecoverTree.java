package pers;

/**
 * 99. 恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 知道怎么校验二叉搜索树，就能做这个题
 * @author cck
 * @date 2022/4/4 12:36
 */
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        // 知道怎么校验二叉搜索树，就能做这个题
        while (recoverTree(root, null, null)) {
        }
    }

    private boolean recoverTree(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) {
            return false;
        }

        if (min != null && min.val > root.val) {
            swapVal(min, root);
            return true;
        }
        if (max != null && max.val < root.val) {
            swapVal(max, root);
            return true;
        }
        return recoverTree(root.left, min, root)
                || recoverTree(root.right, root, max);
    }

    private void swapVal(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

}
