package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. 所有可能的满二叉树
 * https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 */
public class AllPossibleFBT {

    public List<TreeNode> allPossibleFBT(int N) {

        if (N % 2 == 0) return new ArrayList<TreeNode>(0);

        if (N == 1) {
            List<TreeNode> list = new ArrayList<>(1);
            list.add(new TreeNode(0));
            return list;
        }

        List<TreeNode> res = new ArrayList<>();

        for (int i = 1; i < N; i += 2) {

            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);

            for (TreeNode n1 : left) {

                for (TreeNode n2 : right) {

                    TreeNode head = new TreeNode(0);
                    head.left = n1;
                    head.right = n2;
                    res.add(head);
                }
            }
        }

        return res;
    }

}
