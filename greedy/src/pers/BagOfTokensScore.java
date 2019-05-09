package pers;

import java.util.Arrays;

/**
 * 948. 令牌放置
 * https://leetcode-cn.com/problems/bag-of-tokens/comments/
 * @author cck
 */
public class BagOfTokensScore {
    
    public int bagOfTokensScore(int[] tokens, int P) {
        
        if (tokens.length == 0) {
            return 0;
        }
        
        int S = 0;
        Arrays.sort(tokens);
        
        int l = 0;
        int r = tokens.length - 1;
        
        // 把需要很少的能量的都换成分数
        while (l <= r && P >= tokens[l]) {
            P -= tokens[l++];
            S++;
        }
        
        while (l < r && S != 0) {
            
            P += tokens[r--];
            S--;
            
            // 有能量就换分数
            while (P >= tokens[l]) {
                P -= tokens[l++];
                S++;
            }
        }
        
        return S;
    }
    
    public static void main(String[] args) {
        BagOfTokensScore obj = new BagOfTokensScore();
        System.out.println(obj.bagOfTokensScore(new int[]{26}, 51));
        System.out.println(obj.bagOfTokensScore(new int[]{100}, 50));
        System.out.println(obj.bagOfTokensScore(new int[]{100,200}, 150));
        System.out.println(obj.bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }
    
}
