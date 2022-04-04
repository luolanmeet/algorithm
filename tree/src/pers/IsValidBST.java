package pers;

/**
 * 是否是正确的二叉搜索树
 * @author cck
 * @date 2022/4/4 10:53
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {

        // 二叉搜索树，是根节点的值 大于 其左子树中 最大的值，小于 其右子树中 最小的值
        // 因此判断时，需要传入一个值的范围
        return (boolean) isValidBST(root, null, null);
    }

    /**
     * @param root 当前的节点
     * @param min 当前节点允许出现的最小的值
     * @param max 当前节点允许出现的最大的值
     * @return
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        IsValidBST obj = new IsValidBST();
        /**
         *      10
         *   5      15
         *       6   20
         *  10 > 6
         */
        System.out.println(obj.isValidBST(BTreeUtil.bulidTreeWithLevelSeq(new Integer[]{10, 5, 15, null, null, 6, 20})));
        /**
         *      10
         *   5      15
         *     7  14   20
         */
        System.out.println(obj.isValidBST(BTreeUtil.bulidTreeWithLevelSeq(new Integer[]{10, 5, 15, null, 7, 14, 20})));
    }

}
