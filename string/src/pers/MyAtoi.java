package pers;

/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/submissions/
 * @author cck
 */
public class MyAtoi {
    
    public int myAtoi(String str) {
     
        str = str.trim();
    
        if (str.length() == 0) {
            return 0;
        }
        
        char c = str.charAt(0);
        boolean isNegative = false;
        if (c == '-') {
            isNegative = true;
        } else if (c == '+') {
        } else if (c < '0' || c > '9') {
            return 0;
        }
        
        StringBuilder strBuil = new StringBuilder();
        strBuil.append(c);
        for (int i = 1; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp < '0' || tmp > '9') {
                break;
            }
            strBuil.append(tmp);
        }
        // "-" "+" 这种情况
        if ((c == '-' || c == '+') && strBuil.length() == 1) {
            return 0;
        }
        
        try {
            return Integer.valueOf(strBuil.toString());
        } catch (Exception e){
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
    
    public static void main(String[] args) {
        MyAtoi obj = new MyAtoi();
        System.out.println(obj.myAtoi("+42"));
        System.out.println(obj.myAtoi("+"));
        System.out.println(obj.myAtoi("-"));
        System.out.println(obj.myAtoi("   -42"));
        System.out.println(obj.myAtoi("4193 with words"));
        System.out.println(obj.myAtoi("words and 987"));
        System.out.println(obj.myAtoi("-91283472332"));
        System.out.println(obj.myAtoi(" 0000000000012345678"));
    }
    
}
