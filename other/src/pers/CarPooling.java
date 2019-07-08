package pers;

/**
 * 1094. 拼车
 * https://leetcode-cn.com/problems/car-pooling/
 * @author cck
 */
public class CarPooling {
    
    /**
     * 区间加法
     * 这里 end -= 就相当于乘客下车了
     */
    public boolean carPooling(int[][] trips, int capacity) {
     
        int[] res = new int[1001];
        
        for (int i = 0; i < trips.length; i++) {
            
            // start += 
            res[trips[i][1]] += trips[i][0];
            
            // end -=
            res[trips[i][2]] -= trips[i][0];
        }
        
        for (int i = 1; i < 1001; i++) {
            
            res[i] += res[i - 1];
            if (res[i] > capacity) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        CarPooling obj = new CarPooling();
        System.out.println(obj.carPooling(new int[][]{{8,2,3},{4,1,3},{1,3,6},{8,4,6},{4,4,8}}, 12));
        
        System.out.println(obj.carPooling(new int[][]{{2,1,5}, {3,3,7}}, 4));
        System.out.println(obj.carPooling(new int[][]{{2,1,5}, {3,3,7}}, 5));
        System.out.println(obj.carPooling(new int[][]{{2,1,5}, {3,5,7}}, 3));
        System.out.println(obj.carPooling(new int[][]{{3,2,7}, {3,7,9},{8,3,9}}, 11));
    }
    
}
