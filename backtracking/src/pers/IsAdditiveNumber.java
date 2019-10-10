package pers;
/**
 * 306. 累加数
 * https://leetcode-cn.com/problems/additive-number/
 * 没有考虑大数值的情况
 * @author cck
 */
public class IsAdditiveNumber {
    
    public boolean isAdditiveNumber(String num) {
        
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                
                String tmp1 = num.substring(0, i);
                String tmp2 = num.substring(i, j);
                String tmp3 = num.substring(j);
    
                // 排除 01 这种可能
                if (tmp1.startsWith("0") && tmp1.length() != 1
                        || tmp2.startsWith("0") && tmp2.length() != 1
                        || tmp3.startsWith("0") && tmp3.length() != 1) {
                    continue;
                }
                
                Long l1 = Long.valueOf(tmp1);
                Long l2 = Long.valueOf(tmp2);
    
                tmp1 = String.valueOf(l1 + l2);
                
                if (tmp3.startsWith(tmp1)) {
    
                    tmp3 = tmp3.substring(tmp1.length());
                    
                    if (backstrack(tmp2, tmp1, tmp3)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean backstrack(String add1, String add2, String str) {
    
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        Long l1 = Long.valueOf(add1);
        Long l2 = Long.valueOf(add2);
    
        add1 = String.valueOf(l1 + l2);
        
        if (!str.startsWith(add1)) {
            return false;
        }
        
        return backstrack(add2, add1, str.substring(add1.length()));
    }
    
    public static void main(String[] args) {
    
        IsAdditiveNumber obj = new IsAdditiveNumber();
        System.out.println(obj.isAdditiveNumber("101"));
        System.out.println(obj.isAdditiveNumber("1023"));
        System.out.println(obj.isAdditiveNumber("112358"));
        System.out.println(obj.isAdditiveNumber("199100199"));
    
//        String str = "abc";
//        System.out.println(str.substring(1));
    }
    
    
}
