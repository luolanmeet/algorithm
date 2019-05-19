package pers;

import java.util.HashMap;
import java.util.Map;

/**
 * 740. 删除与获得点数
 * https://leetcode-cn.com/problems/delete-and-earn/
 * @author cck
 */
public class DeleteAndEarn {
    
    public int deleteAndEarn(int[] nums) {
       
        // 保存从 0 到 i，能获得的最大的点数
        int[] dp = new int[10001];
        int[] sum = new int[10001];
        int max = 0;
        for (int num : nums) {
            sum[num] += num;
            max = Math.max(max, num);
        }

        dp[0] = 0;
        dp[1] = sum[1];
        
        for (int i = 2; i <= max; i++) {
            // 选择要当前 i 的分数，则 dp[i] 就是 sum[i] + dp[i - 2]
            // 选择不要 i 的分数，也就是要 i - 1 的分数 dp[i - 1]
            dp[i] = Math.max(sum[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[max];
    }
    
    // 暴力
    public int deleteAndEarn2(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        return method(map);
    }

    private int method(Map<Integer, Integer> map) {
        
        if (map.size() == 0) {
            return 0;
        }
        
        int res = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            Map<Integer, Integer> tempMap = new HashMap<>(map);
            
            Integer val   = entry.getKey();
            Integer count = entry.getValue();
            
            tempMap.remove(val - 1);
            tempMap.remove(val + 1);
            
            if (count == 1) {
                tempMap.remove(val);
            } else {
                tempMap.put(val, count - 1);
            }
            
            res = Math.max(res, val + method(tempMap));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        DeleteAndEarn obj = new DeleteAndEarn();
        System.out.println(obj.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(obj.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(obj.deleteAndEarn(new int[]{8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4}));
    }
    
}
