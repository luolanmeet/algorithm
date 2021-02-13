package pers;

/**
 * 克隆二叉树
 * @author cck
 */
public class BinaryTreeCopy {
    
    public TreeNode copy(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        TreeNode newNode = new TreeNode(root.val);
        
        newNode.left = copy(root.left);
        newNode.right = copy(root.right);
        
        return newNode;
    }
    
    public static void main(String[] args) {
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        
        BinaryTreeCopy obj = new BinaryTreeCopy();
        obj.preTraverse(t1);
        System.out.println();
        obj.preTraverse(obj.copy(t1));
    }
    
    // 前序遍历
    public void preTraverse(TreeNode root) {
        
        if (root == null) {
            return ;
        }
        
        System.out.print(root.val + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }
    
}
