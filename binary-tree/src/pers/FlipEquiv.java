package pers;

/**
 * 翻转等价二叉树
 * https://leetcode-cn.com/problems/flip-equivalent-binary-trees/
 * @author cck
 */
public class FlipEquiv {
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        
        if (root1.val == root2.val) {
            
            // 比较子节点
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                        ||
                   (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        TreeNode root1 = initTreeOne();
        TreeNode root2 = initTreeTwo();
        FlipEquiv obj = new FlipEquiv();
        System.out.println(obj.flipEquiv(root1, root2));
    }

    private static TreeNode initTreeOne() {
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t5.left = t7;
        t5.right = t8;
        
        return t1;
    }
    
    private static TreeNode initTreeTwo() {
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t6.left = t7;
        t6.right = t8;
        
        return t1;
    }

    
}
