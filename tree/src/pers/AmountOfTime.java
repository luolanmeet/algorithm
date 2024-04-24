package pers;

/**
 * 2385. 感染二叉树需要的总时间
 * https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 * 找到树中距离目标节点最远的节点
 * @auther ken.ck
 * @date 2024/4/24 10:28
 */
public class AmountOfTime {

    // 最短用时
    int ans = 0;
    // 其实节点的高度
    int depth = -1;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, 0, start);
        return ans;
    }

    private int dfs(TreeNode root, int level, int start) {
        if (root == null) {
            return 0;
        }
        // 当前节点就是起始节点
        if (root.val == start) {
            depth = level;
        }
        // 左子树的树高
        int l = dfs(root.left, level + 1, start);
        // 其实阶段是否在左子树上
        boolean inLeft = depth != -1;
        // 右子树的树高
        int r = dfs(root.right, level + 1, start);
        // 情况1，感染以 start 为根节点的树所需时间
        if (root.val == start) {
            ans = Math.max(ans, Math.max(l, r));
        }
        // 情况2，感染以 root 为根结点的树所需的时间
        if (inLeft) {
            ans = Math.max(ans, depth - level + r);
        } else {
            ans = Math.max(ans, depth - level + l);
        }
        return Math.max(l, r) + 1;
    }

    /**
     * 纯暴力解法，超时了
     * @param root
     * @param start
     * @return
     */
    public int amountOfTime2(TreeNode root, int start) {
        int tmp = 0;
        while (true) {
            int count = dfs2(root, start, tmp);
            if (count <= 0) {
                break;
            }
            start = tmp;
            tmp--;
        }
        return  0 - tmp;
    }

    private int dfs2(TreeNode root, int pre, int next) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 被感染
        if (root.val == pre) {
            root.val = next;
            if (root.left != null && root.left.val != pre) {
                root.left.val = next;
                res++;
            }
            if (root.right != null && root.right.val != pre) {
                root.right.val = next;
                res++;
            }
        } else {
            if (root.left != null && root.left.val == pre) {
                root.val = next;
                res++;
            } else if (root.right != null && root.right.val == pre) {
                root.val = next;
                res++;
            }
        }

        res += dfs(root.left, pre, next);
        res += dfs(root.right, pre, next);
        return res;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(2);
        t2.right = t4;
        t4.left = t5;
        t4.right = t6;

        TreeNode t7 = new TreeNode(10);
        TreeNode t8 = new TreeNode(6);
        t3.left = t7;
        t3.right = t8;

        AmountOfTime obj = new AmountOfTime();
        System.out.println(obj.amountOfTime(t1, 3));
    }


}
