package pers;

/**
 * 124. 二叉树中的最大路径和
 * @author cck
 * @date 2020/12/15 23:34
 */
public class MaxPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxTraverse(root);
        return ans;
    }

    public int maxTraverse(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxTraverse(root.left));
        int right = Math.max(0, maxTraverse(root.right));

        ans = Math.max(left + right + root.val, ans);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        MaxPathSum obj = new MaxPathSum();
        System.out.println(obj.maxPathSum(t1));
    }

}
