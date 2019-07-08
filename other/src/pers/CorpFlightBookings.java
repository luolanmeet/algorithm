package pers;

import java.util.Arrays;

/**
 * 5118. 航班预订统计
 * https://leetcode-cn.com/problems/corporate-flight-bookings/ 
 * @author cck
 */
public class CorpFlightBookings {
    
    /**
     * 使用区间加法
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] res = new int[n];
        
        for (int i = 0; i < bookings.length; i++) {
            
            // start += 
            res[bookings[i][0] - 1] += bookings[i][2];
            
            // end -=
            if (bookings[i][1] < n) {
                res[bookings[i][1]] -= bookings[i][2];
            }
        }
        
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        CorpFlightBookings obj = new CorpFlightBookings();
        System.out.println(Arrays.toString(obj.corpFlightBookings(new int[][]{{1,2,10}, {2,3,20}, {2,5,25}}, 5)));
    }
    
    /* 直接算，会超时
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        Arrays.sort(bookings, (t1, t2) -> {
            return t1[0] - t2[0];
        });
        
        int[] res = new int[n];
        
        for (int i = 1; i <= n; i++) {
        
            int add = 0;
            
            for (int j = 0; j < bookings.length; j++) {
                if (bookings[j][0] > i) {
                    break;
                }
                
                if (bookings[j][1] >= i) {
                    add += bookings[j][2]; 
                }
            }
            
            res [i - 1] = add;
        }
        
        return res;
    }*/
    
    
}
