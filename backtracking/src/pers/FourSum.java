package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resp = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                // 去重
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                int min = nums[i] + nums[j] + nums[left] + nums[left + 1];
                int max = nums[i] + nums[j] + nums[right] + nums[right - 1];

                if (min > target || max < target) {
                    continue;
                }

                while (left < right) {

                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];

                    if (tmp == target) {
                        resp.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++; right--;
                    } else if (tmp > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return resp;
    }

    public static void main(String[] args) {
        FourSum obj = new FourSum();
        List<List<Integer>> resp = obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(resp);
    }

}
