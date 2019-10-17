package pers;

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Multiply {
    
    public String multiply(String num1, String num2) {
        
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int tmp = n1 * n2 + res[i + j + 1];
                res[i + j + 1] = tmp % 10;
                res[i + j] += tmp / 10;
            }
        }
        
        StringBuilder strBuil = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            strBuil.append(res[i]);
        }
        
        return strBuil.toString();
    }
    
    public static void main(String[] args) {
        Multiply obj = new Multiply();
        System.out.println(obj.multiply("123", "45"));
        System.out.println(obj.multiply("123", "4521"));
        System.out.println(obj.multiply("4521", "123"));
    }
    
}
