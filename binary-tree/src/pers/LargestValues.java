package pers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @author cck
 */
public class LargestValues {
    
    // 层次遍历即可
    public List<Integer> largestValues(TreeNode root) {
        
        if (root == null) {
            return Collections.emptyList();
        }
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int maxVal = queue.peek().val;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
                maxVal = Math.max(maxVal, node.val);
            }
            
            res.add(maxVal);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
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
        
        LargestValues obj = new LargestValues();
        System.out.println(obj.largestValues(t1));
    }
    
}
