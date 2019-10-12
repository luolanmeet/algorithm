package pers;

/**
 * 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author cck
 */
public class Convert {
    
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        
        int numRows2 = numRows - 2;
    
        char[][] ccs = new char[numRows][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
        
            // 计算位置 x y
    
            int l = i / (numRows + numRows2) * (numRows - 1);
            int k = i % (numRows + numRows2) + 1;
    
            int x = k;
    
            if (k > numRows) {
                k -= numRows;
                x = numRows - k;
            } else {
                k = 0;
            }
    
            x--;
    
            int y = l  + k;
    
            ccs[x][y] = s.charAt(i);
        }

        StringBuilder strBuil = new StringBuilder();
        
        char[] tmp = new char[1];
        
        for (char[] cs : ccs) {
            for (char c : cs) {
                if (c ==tmp[0]) {
                    continue;
                }
                strBuil.append(c);
            }
        }
        
        return strBuil.toString();
    }
    
    public static void main(String[] args) {
        Convert obj = new Convert();
        System.out.println(obj.convert("LEETCODEISHIRING", 4).length());
        System.out.println(obj.convert("LEETCODEISHIRING", 3).length());
        System.out.println(obj.convert("ABCDE", 4));
    }
    
}
