package pers;

import java.util.ArrayList;
import java.util.List;

/**
 *  842. 将数组拆分成斐波那契序列
 *  https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 *  和 306. 累加数是一样的
 * @author cck
 */
public class SplitIntoFibonacci {
    
    public List<Integer> splitIntoFibonacci(String num) {
    
        for (int i = 1; i < num.length() - 1; i++) {
            
            Integer l1 = null;
            String tmp1 = num.substring(0, i);
            try {
                l1 = Integer.valueOf(tmp1);
            } catch (Exception e) {
                break;
            }
            
            for (int j = i + 1; j < num.length(); j++) {
            
                String tmp2 = num.substring(i, j);
                String tmp3 = num.substring(j);
            
                // 排除 01 这种可能
                if (tmp1.startsWith("0") && tmp1.length() != 1
                        || tmp2.startsWith("0") && tmp2.length() != 1) {
                    continue;
                }
    
                Integer l2 = null;
                try {
                    l2 = Integer.valueOf(tmp2);
                } catch (Exception e) {
                    break;
                }
            
                tmp1 = String.valueOf(l1 + l2);
            
                if (tmp3.startsWith(tmp1)) {
                
                    tmp3 = tmp3.substring(tmp1.length());
    
                    List<Integer> list = new ArrayList<>();
                    list.add(l1);
                    list.add(l2);
                    list.add(l1 + l2);
                    
                    if (backstrack(tmp2, tmp1, tmp3, list)) {
                        return list;
                    }
                }
            }
        }
        
        return new ArrayList<Integer>();
    }
    
    private boolean backstrack(String add1, String add2, String str, List<Integer> list) {
        
        if (str == null || str.isEmpty()) {
            return true;
        }
    
        Integer l1 = Integer.valueOf(add1);
        Integer l2 = Integer.valueOf(add2);
        
        add1 = String.valueOf(l1 + l2);
        
        if (!str.startsWith(add1)) {
            return false;
        }
        
        list.add(l1 + l2);
        return backstrack(add2, add1, str.substring(add1.length()), list);
    }
    
    public static void main(String[] args) {
        SplitIntoFibonacci obj = new SplitIntoFibonacci();
        System.out.println(obj.splitIntoFibonacci("0000"));
        System.out.println(obj.splitIntoFibonacci("000000000"));
        System.out.println(obj.splitIntoFibonacci("123456579"));
        System.out.println(obj.splitIntoFibonacci("11235813"));
        System.out.println(obj.splitIntoFibonacci("112358130"));
        System.out.println(obj.splitIntoFibonacci("1101111"));
        System.out.println(obj.splitIntoFibonacci("214748364721474836422147483641"));
    }
    
}
