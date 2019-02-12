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
        Arrays.sort(nums); // O(NLongN);

        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // avoid duplications

            // 2 pointers
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));

                    while (lo < hi && nums[lo - 1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi + 1] == nums[hi]) hi--;
                } else if (sum < 0) lo++;
                else hi--;
            }
        }

        return result;
    }
}
