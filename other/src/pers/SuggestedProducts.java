package pers;

import java.util.*;

/**
 * 前缀树
 * 1268. 搜索推荐系统
 * https://leetcode.cn/problems/search-suggestions-system/
 * @auther ken.ck
 * @date 2023/9/2 11:13
 */
public class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        // 暴力
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String s = searchWord.substring(0, i);
            List<String> tmp = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(s)) {
                    tmp.add(product);
                }
                if (tmp.size() == 3) {
                    break;
                }
            }
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        SuggestedProducts obj = new SuggestedProducts();
    }

}
