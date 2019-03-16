package pers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II 
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * @author cck
 */
public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        
        // nums * 2
        int len = nums.length;
        int[] nums2 = new int[len * 2];
        
        for (int i = 0; i < len; i++) {
            nums2[i] = nums[i];
            nums2[len + i] = nums[i];
        }
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();        
        
        for (int i = 0; i < len * 2; i++) {
            
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(i);
        }
        
        int[] resp = new int[len];
        
        for (int i = 0; i < len; i++) {
            resp[i] = map.getOrDefault(i, -1);
        }
        
        return resp;
    }
    
    public static void main(String[] args) {
        NextGreaterElements obj = new NextGreaterElements();
        System.out.println(Arrays.toString(obj.nextGreaterElements(new int[]{1,2,1})));
    }
    
}
