package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 955. 删列造序 II
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted-ii/
 * @author cck
 */
public class MinDeletionSize2 {
    
    public int minDeletionSize(String[] A) {
        
        List<String> ss = new ArrayList<>(A.length);
        for (String a : A) {
            ss.add(a);
        }
        
        List<Integer> delete = new ArrayList<>();
        calc(ss, 0, A[0].length(), delete);
        return delete.size();
    }
    
    private void calc(List<String> ss, int index, int len, List<Integer> delete) {
        
        if (index >= len) {
            return ;
        }
        
        // 如果这位已经被删了，则比较下一位
        if (delete.contains(index)) {
            calc(ss, index + 1, len, delete);
        }
        
        Map<Character, List<String>> tempMap = new HashMap<>(ss.size());
        
        char preChar = 'a' - 1;
        boolean hasAdd = false;
        for (int i = 0; i < ss.size(); i++) {
            
            String tempStr = ss.get(i);
            char tempChar = tempStr.charAt(index);
            
            // 删除 index 这个位置
            if (tempChar < preChar) {
                
                if (!delete.contains(index)) {
                    delete.add(index);
                }
                calc(ss, index + 1, len, delete);
                return ;
            }
            
            if (tempChar == preChar) {
                
                List<String> temp = tempMap.get(tempChar);
                if (temp == null) {
                    temp = new ArrayList<>(ss.size());
                    tempMap.put(tempChar, temp);
                }
                if (!hasAdd) {
                    temp.add(ss.get(i - 1));
                    hasAdd = true;
                }
                temp.add(tempStr);
            } else {
                hasAdd = false;
            }
            
            preChar = tempChar;
        }
        if (tempMap.isEmpty()) {
            return;
        }
        for (List<String> list : tempMap.values()) {
            calc(list, index + 1, len, delete);
        }
    }

    public static void main(String[] args) {
        
        MinDeletionSize2 obj = new MinDeletionSize2();
        
        System.out.println(obj.minDeletionSize(new String[]{"ca","bb","ac"})); // 1
        System.out.println(obj.minDeletionSize(new String[]{"xc","yb","za"})); // 0
        System.out.println(obj.minDeletionSize(new String[]{"zyx","wvu","tsr"})); //3
        System.out.println(obj.minDeletionSize(new String[]{"xga","xfb","yfa"})); // 1
        System.out.println(obj.minDeletionSize(new String[]{"abx","agz","bgc","bfc"})); // 1
        System.out.println(obj.minDeletionSize(new String[]
                {"bwwdyeyfhc","bchpphbtkh","hmpudwfkpw","lqeoyqkqwe","riobghmpaa",
                        "stbheblgao","snlaewujlc","tqlzolljas","twdkexzvfx","wacnnhjdis"})); // 4
        System.out.println(obj.minDeletionSize(new String[]
                {"voibobzhfx","qpabpzscga","bjobaztasc","lnbcakfmnq","tjsikfdsix","dloiskwypl",
                        "eaeqmujszw","utfrgwyijs","rxgyhhladh","rmryzonepz"})); // 4
    }
    
}
