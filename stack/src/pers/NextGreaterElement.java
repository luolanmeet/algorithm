package pers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * @author cck
 */
public class NextGreaterElement {
    
    // 单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums2) {
            
            // 所有比num小的，都会被设置
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] resp = new int[nums1.length];
        
        int i = 0;
        for (int num : nums1) {
            resp[i++] = map.getOrDefault(num, -1);
        }
        
        return resp;
    }
    
    public static void main(String[] args) {
        
        NextGreaterElement obj = new NextGreaterElement();
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
    
}
