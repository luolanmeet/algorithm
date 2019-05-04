package pers;

/**
 * 738. 单调递增的数字 
 * https://leetcode-cn.com/problems/monotone-increasing-digits/comments/
 * @author cck
 */
public class MonotoneIncreasingDigits {
    
    public int monotoneIncreasingDigits(int N) {
        
        if (N < 10) {
            return N;
        }
        
        int preVal = N % 10;   // 个位上的数
        int res = preVal;      // 保存当前的结果
        int mult = 10;         //　倍数
        N /= 10;
        
        while (N != 0) {
            
            int tempVal = N % 10;
            if (tempVal > preVal) {  
                tempVal--;
                res = mult - 1; // 如果 当前位减1，则当前位右边的值都可取最大值 9
            }
            
            res += tempVal * mult; // 加上 当前位
            N /= 10;
            preVal = tempVal;
            mult *= 10;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        MonotoneIncreasingDigits obj = new MonotoneIncreasingDigits();
        System.out.println(obj.monotoneIncreasingDigits(10));
        System.out.println(obj.monotoneIncreasingDigits(1234));
        System.out.println(obj.monotoneIncreasingDigits(332));
    }
    
}
