package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author cck
 */
public class PathSum {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        
        addPath(root, res, l, sum, 0);
        
        return res ;        
    }

    private void addPath(
            TreeNode node, 
            List<List<Integer>> res, 
            List<Integer> list, 
            int sum, int sumNow) {
        
        if (node == null) {
            return ;
        }
        
        sumNow += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            
            if (sumNow == sum) {
                res.add(list);
                return ;
            }
        }
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        l1.addAll(list);
        l2.addAll(list);
        
        addPath(node.left, res, l1, sum, sumNow);
        addPath(node.right, res, l2, sum, sumNow);
    } 
    
    public static void main(String[] args) {
        
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        
        n1.left = n2;
        n1.right = n3;
        
        n2.left = n4;
        
        n3.left = n5;
        n3.right = n6;
        
        n4.left = n7;
        n4.right = n8;
        
        n6.left = n9;
        n6.right = n10;
        
        PathSum obj = new PathSum();
        System.out.println(obj.pathSum(n1, 22));
    }
    
}
