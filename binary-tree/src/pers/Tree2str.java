package pers;

/**
 * 606. 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * @author cck
 */
public class Tree2str {
    
    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }
        
        StringBuilder str = new StringBuilder();
        tree2strMethod(str, t);
        
        return str.toString();        
    }

    private void tree2strMethod(StringBuilder str, TreeNode t) {
        
        str.append(t.val);
        
        if (t.left == null && t.right != null) {
            str.append("()");
            str.append("(");
            tree2strMethod(str, t.right);
            str.append(")");
            return;
        }
        
        if (t.left != null) {
            str.append("(");
            tree2strMethod(str, t.left);
            str.append(")");
        }
        
        if (t.right != null) {
            str.append("(");
            tree2strMethod(str, t.right);
            str.append(")");
        }
    }    
    
    public static void main(String[] args) {
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        
        Tree2str obj = new Tree2str();
        System.out.println(obj.tree2str(n1));
    }
    
}
