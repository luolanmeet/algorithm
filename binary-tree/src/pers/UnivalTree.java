package pers;

/**
 * 单值二叉树
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * @author cck
 */
public class UnivalTree {
    
    // 就是一个二叉树的遍历
    public boolean isUnivalTree(TreeNode root) {
    
        if (root == null) {
            return true;
        }
        
        int val = root.val;
        return jundge(root, val);
    }

    private boolean jundge(TreeNode root, int val) {
        
        if (root == null) {
            return true;
        }
        
        if (root.val != val) {
            return false;
        }
        
        if (!jundge(root.left, val)) {
            return false;
        }
        
        return jundge(root.right, val);
    }
    
    public static void main(String[] args) {
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);
        
        t1.left = t2; t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t5.left = t6;

        UnivalTree obj = new UnivalTree();
        
        System.out.println(obj.isUnivalTree(t1));
        t6.val = 2;
        System.out.println(obj.isUnivalTree(t1));
    }
    
}
