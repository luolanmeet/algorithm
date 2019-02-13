package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * @author cck
 */
public class WidthOfBinaryTree {
    
    int maxW = 0;
    
    // 利用了满二叉树的特性（尽管这里的树不一定是满二叉树）
    public int widthOfBinaryTree(TreeNode root) {
        
        dfs(root, 1, 1, new ArrayList<Integer>());
        
        return maxW;
    }

    private void dfs(TreeNode root, int level, int index, List<Integer> left) {
        
        if (root == null) {
            return ;
        }
        
        // 还没有这一层最左边的节点的序列
        if (level > left.size()) {
            left.add(index);
        }
        
        maxW = Math.max(maxW, index - left.get(level-1)+1);
        
        dfs(root.left, level + 1, index * 2, left);
        dfs(root.right, level + 1, index * 2 + 1, left);
    }
    
    public static void main(String[] args) {
        
        WidthOfBinaryTree obj = new WidthOfBinaryTree();
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        
        System.out.println(obj.widthOfBinaryTree(t1));
    }
    
}
