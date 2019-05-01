package pers;

import java.util.Arrays;

/**
 * 621. 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 * @author cck
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        
        if (tasks.length < 1) {
            return 0;
        }
        
        int[] count = new int[36];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        // 按照任务的数量升序排序
        Arrays.sort(count);
        
        // 最多的任务的数量
        int maxCount = count[count.length - 1];
        
        // 安排好最多的任务需要的时间    【A + n个待命】...【A + n个待命】
        int res = (n + 1) * maxCount;
        // 最少调度时间    【A + n个待命】...【A】
        int minRes = res - n;
        // 待命时间的总和 
        int await = maxCount * n;
        
        for (int i = count.length - 2; i > 0; i--) {
            
            // 任务数量也是最多的， 修正最少调度时间 【A + n个待命】...【A】 +1
            if (count[i] == maxCount) {
                minRes++;
            }
            //　减去新的任务用去的待命时间，await可以为负数
            await -= count[i];
        }
        res -= await;
        
        return minRes > res ? minRes : res;
    }
    
    public static void main(String[] args) {
        
        LeastInterval obj = new LeastInterval();
        System.out.println(obj.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        
    }
    
}
