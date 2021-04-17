package pers.doublePoint.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 220. 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @author cck
 * @date 2021/4/17 12:11
 */
public class ContainsNearbyAlmostDuplicate {

    public static class Node {
        long val;
        long idx;
        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    /**
     * 排序后 用滑动窗口算法
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length == 0 || nums.length == 1)
            return false;
        if (k == 0)
            return false;

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            nodes.add(new Node(nums[i], i));

        nodes.sort((n1, n2) -> {
            if (n1.val > n2.val) {
                return 1;
            }
            if (n1.val < n2.val) {
                return -1;
            }
            return n1.idx > n2.idx ? 1 : -1;
        });

        int l = 0,  r = 1;
        while (r < nodes.size()) {

            for (int i = r - 1; i >= l; i--) {
                if (nodes.get(r).val - nodes.get(i).val > t) {
                    break;
                }
                if (Math.abs(nodes.get(r).idx - nodes.get(i).idx) <= k) {
                    return true;
                }
            }

            while (nodes.get(r).val - nodes.get(l).val > k) {
                l++;
            }

            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate obj = new ContainsNearbyAlmostDuplicate();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }

}
