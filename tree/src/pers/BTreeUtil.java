package pers;

/**
 * @author cck
 * @date 2022/4/4 11:12
 */
public class BTreeUtil {

    /**
     * 根据层次遍历构造树对象，注意，序列需要按完全x叉树给出
     * @param nodes
     * @return
     */
    public static TreeNode bulidTreeWithLevelSeq(Integer[] nodes) {

        if (nodes == null || nodes.length <= 0) {
            return null;
        }

        TreeNode[] ts = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                continue;
            }

            // 创建树节点
            ts[i] = new TreeNode(nodes[i]);

            // 定位父节点
            int pidx = (i - 1) / 2;
            if (pidx < 0) {
                continue;
            }
            // 确定左右孩子
            if (i % 2 == 0) {
                ts[pidx].right = ts[i];
            } else {
                ts[pidx].left = ts[i];
            }
        }
        return ts[0];
    }

    public static void main(String[] args) {

        TreeNode root = bulidTreeWithLevelSeq(new Integer[]{0, 1, 2, 3, 4, 5, 6});
        System.out.println(root);
    }

}
