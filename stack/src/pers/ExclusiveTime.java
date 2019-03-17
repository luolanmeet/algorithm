package pers;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 * https://leetcode-cn.com/problems/exclusive-time-of-functions/
 * @author cck
 */
public class ExclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        
        // 函数开始时间
        Stack<Integer> starts = new Stack<>();
        // 相对于前一个函数而言，已经调用过的函数所花费的总时间
        Stack<Integer> adds = new Stack<>();
        
        for (String log : logs) {
            
            String[] ss = log.split(":");
            
            Integer id = Integer.valueOf(ss[0]);
            Integer time = Integer.valueOf(ss[2]);
            
            if ("start".equals(ss[1])) {
                starts.push(time);
                adds.push(0);
                continue;
            }
            
            int addTime = time - starts.pop() + 1;
            
            // 加上开始-结束的时间
            res[id] += addTime;
            // 减去开始和结束时间中，调用其他函数的时间（包括调用自己）
            res[id] -= adds.pop();
            
            // 维护
            if (!starts.isEmpty()) {
                adds.push(adds.pop() + addTime);
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        ExclusiveTime obj = new ExclusiveTime();
        int[] time = obj.exclusiveTime(2, Arrays.asList(
                "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"));
        System.out.println(Arrays.toString(time));
        
        time = obj.exclusiveTime(1, Arrays.asList(
                "0:start:0",
                "0:start:1",
                "0:start:2",
                "0:end:3",
                "0:end:4",
                "0:end:5"));
        System.out.println(Arrays.toString(time));
        
        time = obj.exclusiveTime(1, Arrays.asList(
                "0:start:0",
                "0:start:2",
                "0:end:5",
                "0:start:6",
                "0:end:6",
                "0:end:7"));
        System.out.println(Arrays.toString(time));
    }
    
}
