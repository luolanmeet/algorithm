package pers;

/**
 * 495. 提莫攻击
 * https://leetcode-cn.com/problems/teemo-attacking/comments/
 * @author cck
 */
public class FindPoisonedDuration {
    
    public int findPoisonedDuration(int[] timeSeries, int duration) {
     
        if (timeSeries.length <= 0) {
            return 0;
        }
        
        int end = timeSeries[0] + duration - 1; // 中毒结束的时间
        int res = duration;
        
        for (int i = 1; i < timeSeries.length; i++) {

            if (timeSeries[i] <= end) {
                
                // 如果中毒时间未结束时继续攻击，则上次攻击的中毒时间不是完整的duration，而是 timeSeries[i] - timeSeries[i - 1], 
                // 这里其实是先【res-=duration】上次的中毒时间， 然后加上这次中毒的时间【res+=duration】。被约去了。
                
                res += timeSeries[i] - timeSeries[i - 1];
            } else {
                res += duration;
            }
            
            end = timeSeries[i] + duration - 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        FindPoisonedDuration obj = new FindPoisonedDuration();
        System.out.println(obj.findPoisonedDuration(new int[] {1,4}, 2));
        System.out.println(obj.findPoisonedDuration(new int[] {1,2}, 2));
    }
    
}
