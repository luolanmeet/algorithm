package pers;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/comments/
 * @author cck
 */
public class CanJump {
    
    public boolean canJump(int[] nums) {
        
        int farIndex = nums[0];
        if (farIndex >= nums.length - 1) {
            return true;
        }
        
        // 最远能抵达的地方：farIndex 
        // 每次都在 【当前位置+1，farIndex】 的区间找下一个farIndex
        for (int i = 0; i < nums.length; ) {
            
            int tempIndex = farIndex;
            for (int j = i + 1; j <= farIndex; j++) {
                
                if (nums[j] + j > tempIndex) {
                    tempIndex = nums[j] + j;
                }
            }
            
            if (i == farIndex) {
                return false;
            }
            if (tempIndex >= nums.length - 1) {
                return true;
            }
            
            i = farIndex;
            farIndex = tempIndex;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        CanJump obj = new CanJump();
        System.out.println(obj.canJump(new int[] {1,2,3}));
        System.out.println(obj.canJump(new int[] {2,3,1,1,4}));
        System.out.println(obj.canJump(new int[] {3,2,1,0,4}));
    }
    
}
