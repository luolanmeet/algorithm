package pers;

import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    
     // 回溯的解法，做剪枝也会超时
     // 见array中的解法
    public List<List<Integer>> threeSum(int[] nums) {
    
        Arrays.sort(nums);
        
        if (nums.length < 3 || nums[nums.length - 1] < 0) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new Stack<>(), 0, 0);
        
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, Stack<Integer> stack, int sum, int index) {
    
        if (sum == 0 && stack.size() == 3) {
            res.add(new ArrayList<>(stack));
        }
        
        if (index >= nums.length || stack.size() >= 3) {
            return ;
        }
        
        if (stack.size() == 2 && sum + nums[nums.length - 1] < 0) {
            return ;
        }
        
        if (stack.size() == 1 && sum + nums[nums.length - 2] + nums[nums.length - 1] < 0) {
            return ;
        }
        
        stack.push(nums[index]);
        backtrack(nums, res, stack, sum + nums[index], index + 1);
        int pre = stack.pop();
        for (int i = index + 1; i < nums.length; i++) {
        
            if (nums[i] == pre) {
                continue;
            }
    
            stack.push(nums[i]);
            backtrack(nums, res, stack, sum + nums[i], i + 1);
            pre = stack.pop();
        }
    }
    
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        System.out.println(obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(obj.threeSum(new int[]{82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-28801,324,1202,-90885,-2989,-95597,-34333,35528,5680,89093,-90606,50360,-29393,-27012,53313,65213,99818,-82405,-41661,-3333,-51952,72135,-1523,26377,74685,96992,92263,15929,5467,-99555,-43348,-41689,-60383,-3990,32165,65265,-72973,-58372,12741,-48568,-46596,72419,-1859,34153,62937,81310,-61823,-96770,-54944,8845,-91184,24208,-29078,31495,65258,14198,85395,70506,-40908,56740,-12228,-40072,32429,93001,68445,-73927,25731,-91859,-24150,10093,-60271,-81683,-18126,51055,48189,-6468,25057,81194,-58628,74042,66158,-14452,-49851,-43667,11092,39189,-17025,-79173,13606,83172,92647,-59741,19343,-26644,-57607,82908,-20655,1637,80060,98994,39331,-31274,-61523,91225,-72953,13211,-75116,-98421,-41571,-69074,99587,39345,42151,-2460,98236,15690,-52507,-95803,-48935,-46492,-45606,-79254,-99851,52533,73486,39948,-7240,71815,-585,-96252,90990,-93815,93340,-71848,58733,-14859,-83082,-75794,-82082,-24871,-1}));
    }
    
}
