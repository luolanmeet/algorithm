package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 * @author cck
 */
public class PartitionLabels {
    
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> res = new ArrayList<>();
        
        // 上个片段的边界
        int preIndex = -1;
        
        char[] cs = S.toCharArray();
        
        for (int i = 0; i < cs.length; i++) {
            
            int index = S.lastIndexOf(cs[i]);
            
            // 表示是一个新的片段的开始
            if (i > preIndex) {
                res.add(index - i + 1);
                preIndex = index;
                continue;
            } 
            
            // 还在上一个片段之中
            
            // 如果新的边界大于上个片段的边界，则更新上个片段的长度与边界 
            if (index > preIndex) {
                int add = index - preIndex;
                Integer len = res.remove(res.size() - 1);
                res.add(len + add);
                preIndex = index;
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
    }
    
}
