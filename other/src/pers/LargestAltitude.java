package pers;

/**
 * 前缀和
 * 1732. 找到最高海拔
 * https://leetcode.cn/problems/find-the-highest-altitude/
 * @auther ken.ck
 * @date 2023/8/15 20:45
 */
public class LargestAltitude {

    public int largestAltitude(int[] gain) {
        int ans = 0, sum = 0;
        for (int x : gain) {
            sum += x;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestAltitude obj = new LargestAltitude();
        System.out.println(obj.largestAltitude(new int[] {-5,1,5,0,-7}));
        System.out.println(obj.largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
        System.out.println(obj.largestAltitude(new int[] {28,0,-8,-99,11,62,-35,68,2,12,-71,13,66,-28}));
        System.out.println(obj.largestAltitude(new int[] {44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81}));
    }

}
