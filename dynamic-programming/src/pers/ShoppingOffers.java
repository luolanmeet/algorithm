package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 638. 大礼包
 * https://leetcode-cn.com/problems/shopping-offers/comments/
 * @author cck
 */
public class ShoppingOffers {
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return method(price, special, needs, 0);
    }

    private Integer method(
            List<Integer> price, 
            List<List<Integer>> special, 
            List<Integer> needs,
            Integer index) {
        
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }
        
        for (int i = index; i < special.size(); i++) {
            
            List<Integer> tem = new ArrayList<>();
            List<Integer> fee = special.get(i);
            for (int j = 0; j < needs.size(); j++) {
                    
                if (fee.get(j) > needs.get(j)) {
                    tem = null;
                    break;
                }
                tem.add(needs.get(j) - fee.get(j));
            }
            
            // special[j] 这个套餐的数量不符合要求
            if (tem == null) {
                continue;
            }
            
            res = Math.min(res, method(price, special, tem, i) + fee.get(fee.size() - 1));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        
        ShoppingOffers obj = new ShoppingOffers();
        System.out.println(obj.shoppingOffers(
                Arrays.asList(2,5), 
                Arrays.asList(Arrays.asList(3,0,5),Arrays.asList(1,2,10)), 
                Arrays.asList(3,2)));
        System.out.println(obj.shoppingOffers(
                Arrays.asList(2,3,4), 
                Arrays.asList(Arrays.asList(1,1,0,4),Arrays.asList(2,2,1,9)), 
                Arrays.asList(1,2,1)));
    }
    
}
