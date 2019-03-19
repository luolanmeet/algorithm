package pers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author cck
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        
        // 单调递增栈
        Stack<Integer> stack = new Stack<>();
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        
        int i = 0;
        int res = 0;
        
        while (i < h.length) {
            
            if (stack.isEmpty() || h[i] > h[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                
                // 认为当前index的高度是最小的高度，用当前高度去乘宽度
                // 注意，这里的 i 是没变化的，i停留在当前遍历到最右边，用 i 去计算宽度
                // 那些高度连续递增的那些长方形一直被压入栈
                // 递增中断时，弹出，计算面积，然后重复这个过程，继续压栈
                int index = stack.pop();
                res = Math.max(res, h[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        LargestRectangleArea obj = new LargestRectangleArea();
        System.out.println(obj.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    
}
