package pers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author cck
 */
public class DailyTemperatures {
    
    // 和【84. 柱状图中最大的矩形】是一个思路
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack<>();
        
        int[] res = new int[T.length];
        
        int i = 0;
        while (i < T.length) {
            
            if (stack.isEmpty() || T[stack.peek()] >= T[i]) {
                stack.push(i);
                i++;
            } else {
                Integer index = stack.pop();
                res[index] = i - index;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        DailyTemperatures obj = new DailyTemperatures();
        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{80,80,80,34,80,80,34,80,80,80})));
    }
    
}
