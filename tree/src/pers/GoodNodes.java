package pers;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
 * @auther ken.ck
 * @date 2023/8/30 17:36
 */
public class GoodNodes {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 深度遍历
        return dfs(root.left, root.val) + dfs(root.right, root.val) + 1;
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int res = node.val >= val ? 1 : 0;
        val = Math.max(node.val, val);
        res += dfs(node.left, val) + dfs(node.right, val);
        return res;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t3.left = t6;

        GoodNodes obj = new GoodNodes();
        System.out.println(obj.goodNodes(t1));
    }

}
