package pers;

/**
 * 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @author cck
 */
public class SumNumbers {
    
    public int sumNumbers(TreeNode root) {
        return calc(root, 0);
    }

    private int calc(TreeNode node, int val) {
        
        if (node == null) {
            return 0;
        }
        
        val = val * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            return val;
        }
        
        return calc(node.left, val) + calc(node.right, val);
    }
    
    public static void main(String[] args) {
        
        SumNumbers obj = new SumNumbers();
        
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        
        System.out.println(obj.sumNumbers(t1));
        
        TreeNode t4 = new TreeNode(4);
        t3.left = t4;
        
        System.out.println(obj.sumNumbers(t1));
    }
    
}
