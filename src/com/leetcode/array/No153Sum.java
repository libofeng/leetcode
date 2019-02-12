package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(NLongN);

        final List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue; // avoid duplications

            for(int j = i+1;j<nums.length;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int lo = j + 1, hi = nums.length - 1;
                int target = 0 - nums[i] - nums[j];
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    if(target == nums[mid]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[mid]));
                        break;
                    }

                    if(target > nums[mid]) lo = mid + 1;
                    else hi = mid - 1;
                }
            }
        }

        return result;
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
