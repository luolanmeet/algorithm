package pers;

/**
 * 984. 不含 AAA 或 BBB 的字符串
 * https://leetcode-cn.com/problems/string-without-aaa-or-bbb/
 * @author cck
 */
public class StrWithout3a3b {

    public String strWithout3a3b(int A, int B) {
        
        StringBuilder res = new StringBuilder();
        
        int ac = 0;
        int bc = 0;
        
        int len = A + B;
        
        for (int i = 0; i < len; i++) {
            
            if (bc == 2 || A >= B && A > 0 && ac < 2) {
                res.append("a");
                A--;
                ac++;
                bc = 0;
            } else {
                res.append("b");
                B--;
                bc++;
                ac = 0;
            }
        }
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        StrWithout3a3b obj = new StrWithout3a3b();
        System.out.println(obj.strWithout3a3b(1, 2));
        System.out.println(obj.strWithout3a3b(4, 1));
        System.out.println(obj.strWithout3a3b(1, 4));
    }
    
}
