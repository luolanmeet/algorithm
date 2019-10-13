package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/submissions/
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>(k);
        dfs(root, k, list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return ;
        }
        if (list.size() == k) {
            return ;
        }
        dfs(root.left, k, list);
        if (list.size() == k) {
            return ;
        }
        list.add(root.val);
        dfs(root.right, k , list);
    }

    public static void main(String[] args) {
        KthSmallest obj = new KthSmallest();
//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(1);
//        TreeNode n3 = new TreeNode(4);
//        TreeNode n4 = new TreeNode(2);
//        n1.left = n2;
//        n1.right = n3;
//        n2.right = n4;

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

        System.out.println(obj.kthSmallest(n1, 3));
    }

}
