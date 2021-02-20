package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 * @author cck
 */
public class FrequentTreeSum {
    
    int maxCount = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        sumMethod(map, root);
        
        List<Integer> tempList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            if (entry.getValue() == maxCount) {
                tempList.add(entry.getKey());
            }
        }
        
        int[] res = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        
        return res;
    }

    private int sumMethod(Map<Integer, Integer> map, TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int sum = root.val;
        sum += sumMethod(map, root.left);
        sum += sumMethod(map, root.right);
        
        int newCount = 1;
        if (map.containsKey(sum)) {
            newCount += map.get(sum);
        }
        map.put(sum, newCount);
        maxCount = Math.max(maxCount, newCount);
        
        return sum;
    }
    
    public static void main(String[] args) {
        
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-3);
        
        t1.left = t2;
        t1.right = t3;
        
        FrequentTreeSum obj = new FrequentTreeSum();
        System.out.println(Arrays.toString(obj.findFrequentTreeSum(t1)));
    }
    
}
