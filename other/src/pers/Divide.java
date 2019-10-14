package pers;

/**
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Divide {
    
    /**
     * 使用加减法 重点是怎么优化
     */
    public int divide(int dividend, int divisor) {
        
        boolean isNegative = (dividend ^ divisor) < 0;
        
        if (divisor == 1 || divisor == -1) {
            if (!isNegative && dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && dividend > 0 || !isNegative && dividend < 0) {
                return -dividend;
            } else {
                return dividend;
            }
        }
        
        long dividend2 = Math.abs((long)dividend);
        long divisor2 = Math.abs((long)divisor);
        
        int count = 0;
        long tmp = divisor2;
        long tmpAdd = divisor2;
        int tmpCount = 1;
        while (dividend2 >= divisor2) {
            
            count++;
            divisor2 += tmp;
            
            if (dividend2 >= divisor2 + tmpAdd) {
                divisor2 += tmpAdd;
                count += tmpCount;
                tmpAdd += tmpAdd;
                tmpCount += tmpCount;
            } else {
                tmpAdd = tmp;
                tmpCount = 1;
            }
        }
        
        if (isNegative) {
            return -count;
        } else {
            return count;
        }
    }
    
    public static void main(String[] args) {
        Divide obj = new Divide();
        System.out.println(obj.divide(-2147483648, -1));
        System.out.println(obj.divide(-7, 3));
        System.out.println(obj.divide(2000, 2));
    
        System.out.println(obj.divide(Integer.MIN_VALUE, -1));
        System.out.println(obj.divide(Integer.MIN_VALUE, 2));
        System.out.println(obj.divide(Integer.MIN_VALUE, -2));
    }
    
}
