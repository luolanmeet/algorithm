package pers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 987. 二叉树的垂序遍历
 * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 * @author cck
 */
public class VerticalTraversal {
    
    // 层次遍历，然后把值存起来而已
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        
        Queue<Integer> xq = new ArrayDeque<>();
        Queue<TreeNode> nq = new ArrayDeque<>();
        
        nq.offer(root);
        xq.offer(0);
        
        int y = 0; 
        while (!nq.isEmpty()) {
            
            int size = nq.size();
            for (int i = 0; i < size; i++) {
                
                TreeNode node = nq.poll();
                Integer x = xq.poll();
                
                Map<Integer, List<Integer>> map2 = map.get(x);
                
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(x, map2);
                }
                List<Integer> list = map2.get(y);
                if (list == null) {
                    list = new ArrayList<>();
                    map2.put(y, list);
                }
                
                list.add(node.val);
                
                if (node.left != null) {
                    nq.offer(node.left);
                    xq.offer(x-1);
                }
                if (node.right != null) {
                    nq.offer(node.right);
                    xq.offer(x+1);
                }
            }
            y++;
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        List<List<Integer>> resp = new ArrayList<>();
        for (Integer key : keys) {
            
            Map<Integer, List<Integer>> map2 = map.get(key);
            
            List<Integer> partResp = new ArrayList<>();
            
            List<Integer> keys2 = new ArrayList<>(map2.keySet());
            Collections.sort(keys2);
            
            for (Integer key2 : keys2) {
                
                List<Integer> list = map2.get(key2);
                Collections.sort(list);
                partResp.addAll(list);
            }
            
            resp.add(partResp);
        }
        
        return resp;
    }

    public static void main(String[] args) {
        
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
        
//        TreeNode t1 = new TreeNode(0);
//        TreeNode t2 = new TreeNode(8);
//        TreeNode t3 = new TreeNode(1);
//        TreeNode t4 = new TreeNode(3);
//        TreeNode t5 = new TreeNode(2);
//        TreeNode t6 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(5);
//        TreeNode t8 = new TreeNode(7);
//        TreeNode t9 = new TreeNode(6);
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;
//        t4.right = t6;
//        t5.left = t7;
//        t6.right = t8;
//        t7.left = t9;
        
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(6);
        TreeNode t9 = new TreeNode(10);
        TreeNode t10 = new TreeNode(8);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.left = t5;
        t4.right = t6;
        t5.right = t7;
        t6.left = t8;
        t7.left = t9;
        t7.right = t10;
        t8.left = t11;
        t8.right = t12;
        
        VerticalTraversal obj = new VerticalTraversal();
        System.out.println(obj.verticalTraversal(t1));
    }
    
}
                