package pers;

import java.util.Arrays;

/**
 * 881. 救生艇
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * @author cck
 */
public class NumRescueBoats {
    
    public int numRescueBoats(int[] people, int limit) {
     
        int res = 0;
        
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);
        
        // 一次只能做两个人，那就是最轻的和最重的坐一起了
        while (l <= r) {
            res++;
            int temp = people[r--];
            if (temp + people[l] <= limit) {
                l++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        NumRescueBoats obj = new NumRescueBoats();
        System.out.println(obj.numRescueBoats(new int[]{1,2}, 3));
        System.out.println(obj.numRescueBoats(new int[]{1,2,2,3}, 3));
        System.out.println(obj.numRescueBoats(new int[]{3,5,3,4}, 5));
    }
    
}
