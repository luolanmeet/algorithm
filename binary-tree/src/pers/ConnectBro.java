package pers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 填充同一层的兄弟节点
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author cck
 */
public class ConnectBro {
    
    // 就是层次遍历的思路
    public void connect(TreeLinkNode root) {
        
        if (root == null) {
            return ;
        }
        
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            TreeLinkNode preNode = null;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeLinkNode node = queue.poll();
                
                if (preNode != null) {
                    preNode.next = node;
                }
                
                preNode = node;
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    
}
