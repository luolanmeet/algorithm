package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author cck
 */
public class CommonAncestor {
    
    // 解法1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // q 和 p 分布在 root.left 和 root.right 中
        if (left != null && right != null) {
            return root;
        }
        
        return left == null ? right : left;
    }
    
    // 解法2
    // 找到两个节点的所有祖先
    // 之后在结果中找到公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        Map<Integer, TreeNode> map1 = new HashMap<>();
        Map<Integer, TreeNode> map2 = new HashMap<>();
        getAncestor(root, p, map1, 1);
        getAncestor(root, q, map2, 1);
        
        int s = Math.min(map1.size(), map2.size());
        
        for (int i = s; i > 0; i--) {
            
            if (map1.get(i).val == map2.get(i).val) {
                return map1.get(i);
            }
        }
        
        return null;
    }

    private void getAncestor(TreeNode root, TreeNode target, Map<Integer, TreeNode> map, int level) {

        if (root == null) {
            return ;
        }
        
        if (root.val == target.val) {
            map.put(level, root);
            return ;
        }
        
        int size = map.size();
        getAncestor(root.left, target, map, level+1);
        int size2 = map.size();
        
        if (size != size2) {
            map.put(level, root);
            return ;
        }
        
        getAncestor(root.right, target, map, level+1);
        size2 = map.size();
        
        if (size != size2) {
            map.put(level, root);
        }
    }
    
    public static void main(String[] args) {
        
        CommonAncestor obj = new CommonAncestor();
        
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        t2.left = t4;
        t2.right = t5;
        
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        t3.left = t6;
        t3.right = t7;
        
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t5.left = t8;
        t5.right = t9;
        
        TreeNode node = obj.lowestCommonAncestor(t1, t2, t3);
        System.out.println(node.val);
        node = obj.lowestCommonAncestor(t1, t2, t9);
        System.out.println(node.val);
        
        node = obj.lowestCommonAncestor2(t1, t2, t3);
        System.out.println(node.val);
        node = obj.lowestCommonAncestor2(t1, t2, t9);
        System.out.println(node.val);
    }
    
}
