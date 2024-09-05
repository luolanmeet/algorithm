package pers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2860. 让所有学生保持开心的分组方法数
 * https://leetcode.cn/problems/happy-students/description/
 * @auther ken.ck
 * @date 2024/9/4 22:56
 */
public class CountWays {

    public int countWays(List<Integer> nums) {

        Collections.sort(nums);

        int res = 0;
        // 全不选
        if (nums.get(0) > 0) {
            res++;
        }
        // 全选
        if (nums.get(nums.size() - 1) < nums.size()) {
            res++;
        }
        // 排了序，所以遍历时，每个元素都是必选的，最终都计入总数count
        // 循环中值判断选入 i 之后能否满足条件即可
        for (int i = 0, count = 1; i < nums.size(); i++, count++) {
            // 总数 > max(选择的学生)
            if (count > nums.get(i)) {
                // min(不被选的学生) > 总数
                if (nums.size() > i + 1  && nums.get(i + 1) > count) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountWays obj = new CountWays();
        System.out.println(obj.countWays(Arrays.asList(1,1)));
        System.out.println(obj.countWays(Arrays.asList(6,0,3,3,6,7,2,7)));
    }

}
