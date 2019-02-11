package pers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @author cck
 */
public class RightSideView {
    
    // 从右到左的层次遍历
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) {
            return Collections.emptyList();
        }
        
        List<Integer> res = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            res.add(queue.peek().val);
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        
        return res;
    }
    
}
