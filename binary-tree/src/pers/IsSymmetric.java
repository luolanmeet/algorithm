package pers;

/**
 * 是否是对称二叉树 
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author cck
 */
public class IsSymmetric {
    
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        return isSame(root.left, root.right);
    }
    
    public boolean isSame(TreeNode l, TreeNode r) {
        
        if (l == null && r == null) {
            return true;
        }
        
        if (l == null || r == null) {
            return false;
        }
        
        if (l.val != r.val) {
            return false;
        }
        
        return isSame(l.left, r.right) && isSame(r.left, l.right); 
    }
    
    public static void main(String[] args) {
            
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        
        n1.left = n2;
        n1.right = n3;
        
        n2.left = n4;
        n2.right = n5;
        
        n3.left = n6;
        n3.right = n7;
        
        IsSymmetric obj = new IsSymmetric();
        System.out.println(obj.isSymmetric(n1));
    }
    
}
