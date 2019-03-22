package pers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. 行星碰撞
 * https://leetcode-cn.com/problems/asteroid-collision/
 * @author cck
 */
public class AsteroidCollision {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        
        TAG:for (int i = 0; i < asteroids.length; i++) {
            
            // 往右
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                
                int val = -asteroids[i];
                
                // 往左
                while (!stack.isEmpty()) {
                    
                    if (stack.peek() < 0) {
                        break;
                    }
                    
                    if (stack.peek() < val) {
                        stack.pop();
                    } else if (stack.peek() == val) {
                        stack.pop();
                        continue TAG;
                    } else {
                        continue TAG;
                    }
                }
                
                stack.push(asteroids[i]);
            }
            
        }
        
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    
    public static void main(String[] args) {
        
        AsteroidCollision obj = new AsteroidCollision();
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{-2, -1, 1, 2})));
    }
    
}
