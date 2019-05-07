package pers;

/**
 * 649. Dota2 参议院
 * https://leetcode-cn.com/problems/dota2-senate/comments/
 * @author cck
 */
public class PredictPartyVictory {
    
    public String predictPartyVictory(String senate) {
        
        char[] cs = senate.toCharArray();
        boolean[] bs = new boolean[cs.length];  // 该位置的议员是否被禁
        
        int bd = 0; // 要禁的 D 的数量
        int br = 0; // 要禁的 R 的数量
        
        while (true) {
            
            int cd = 0; // D 的数量
            int cr = 0; // R 的数量
            
            for (int i = 0; i < cs.length; i++) {
                
                if (bs[i]) {
                    continue;
                }
                
                if ('D' == cs[i]) {
                    
                    if (bd != 0) {
                        bd--;
                        bs[i] = true;
                    } else {
                        br++;
                        cd++;
                    }
                    
                } else {
                    
                    if (br != 0) {
                        br--;
                        bs[i] = true;
                    } else {
                        bd++;
                        cr++;
                    }
                }
            }
            
            if (cr == 0) {
                return "Dire";
            }
            
            if (cd == 0) {
                return "Radiant";
            }
        }
    }
    
    public static void main(String[] args) {
        
        PredictPartyVictory obj = new PredictPartyVictory();
        System.out.println(obj.predictPartyVictory("RD")); // R
        System.out.println(obj.predictPartyVictory("DDRR")); // D
        System.out.println(obj.predictPartyVictory("DRRD")); // D
    }
    
}
