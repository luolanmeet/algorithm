package pers;

import java.util.Arrays;

/**
 * 179. 最大数
 * https://leetcode.cn/problems/largest-number/
 * @auther ken.ck
 * @date 2024/2/25 20:18
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {

        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = "" + nums[i];
        }
        Arrays.sort(ss, (s1, s2) -> {
            String sa = s1 + s2, sb = s2 + s1;
            return sb.compareTo(sa);
        });
        StringBuilder res = new StringBuilder(new String());
        for (String s : ss) {
            res.append(s);
        }
        while (res.toString().startsWith("0") && res.length() != 1) {
            res = new StringBuilder(res.substring(1, res.length()));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.largestNumber(new int[]{10,2}));
        System.out.println(obj.largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(obj.largestNumber(new int[]{111311, 1113}));
    }

}
