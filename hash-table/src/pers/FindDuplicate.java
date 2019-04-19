package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 609. 在系统中查找重复文件
 * https://leetcode-cn.com/problems/find-duplicate-file-in-system/submissions/
 * @author cck
 */
public class FindDuplicate {
    
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : paths) {
            
            String[] strs = str.split(" ");
            
            for (int i = 1; i < strs.length; i++) {
                
                int index = strs[i].indexOf("(");
                String fileName = strs[i].substring(0, index);
                String content = strs[i].substring(index, strs[i].length());
                
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(strs[0] + "/" + fileName);
                map.put(content, list);
            }
        }
        
        return map.values().stream().filter(v -> v.size() > 1).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        
        FindDuplicate obj = new FindDuplicate();
        List<List<String>> list = obj.findDuplicate(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
        System.out.println(list);
        
    }
    
}
