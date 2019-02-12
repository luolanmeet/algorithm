package pers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * @author cck
 */
public class BottomLeftValue {
    
    // 从左到右的层次遍历，每次保存第一个节点的值
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        int res = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            res = queue.peek().val;
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        
        t1.left = t2;
        t1.right = t3;
        
        BottomLeftValue obj = new BottomLeftValue();
        System.out.println(obj.findBottomLeftValue(t1));
    }
    
}
