package pers;

/**
 * 979. 在二叉树中分配硬币
 * https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/  
 * @author cck
 */
public class DistributeCoins {
    
    int res = 0;
    
    public int distributeCoins(TreeNode root) {
        
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int l = dfs(root.left);
        int r = dfs(root.right);
        res += Math.abs(l) + Math.abs(r);
        return l + r + root.val - 1;
    }
    
    public static void main(String[] args) {
        
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        
        t1.left = t2;
        t1.right = t3;
        
        DistributeCoins obj = new DistributeCoins();
        obj.distributeCoins(t1);
        System.out.println(obj.res);
        
    }
    
}
