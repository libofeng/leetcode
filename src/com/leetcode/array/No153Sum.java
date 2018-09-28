package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> R = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -nums[i] - nums[j], low = j + 1, high = nums.length - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    if (nums[mid] == target) {
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(nums[mid]);

                        R.add(r);
                        break;
                    }
                    if (nums[mid] > target) high = mid - 1;
                    else low = mid + 1;
                }
            }
        }

        return R;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        final List<List<Integer>> R = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int low = i + 1, high = nums.length - 1, target = -nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[low]);
                    r.add(nums[high]);

                    R.add(r);
                    low++;
                    high--;
                    while (low < high && nums[high] == nums[high + 1]) high--;
                    while (low < high && nums[low] == nums[low - 1]) low++;
                } else if (nums[low] + nums[high] > target) {
                    high--;
                    while (low < high && nums[high] == nums[high + 1]) high--;
                } else {
                    low++;
                    while (low < high && nums[low] == nums[low - 1]) low++;
                }
            }
        }

        return R;
    }
}
