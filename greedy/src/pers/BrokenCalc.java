package pers;

/**
 * 991. 坏了的计算器
 * https://leetcode-cn.com/problems/broken-calculator/solution/
 * @author Ryan
 */
public class BrokenCalc {
    
    public int brokenCalc(int X, int Y) {

        int res = 0;
        while (X < Y) {
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
            res++;
        }
        
        return res - Y + X;
    }
    
    public static void main(String[] args) {
        
        BrokenCalc obj = new BrokenCalc();
        System.out.println(obj.brokenCalc(2, 3));
        System.out.println(obj.brokenCalc(5, 8));
        System.out.println(obj.brokenCalc(3, 10));
        System.out.println(obj.brokenCalc(1024, 1));
    }
    
}
