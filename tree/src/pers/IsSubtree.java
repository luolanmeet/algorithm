package pers;

/**
 * 572. 另一棵树的子树
 * https://leetcode.cn/problems/subtree-of-another-tree/description/
 * @auther ken.ck
 * @date 2024/1/20 17:55
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (judge(n1, n2)) {
            return true;
        }
        return dfs(n1.left, n2) || dfs(n1.right, n2);
    }

    private boolean judge(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return judge(n1.left, n2.left) && judge(n1.right, n2.right);
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        IsSubtree obj = new IsSubtree();
        System.out.println(obj.isSubtree(n1, n2));
        System.out.println(obj.isSubtree(n1, n3));
        System.out.println(obj.isSubtree(n1, n4));
        System.out.println(obj.isSubtree(n1, new TreeNode(100)));
    }

}
