package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No169MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public int majorityElement2(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            int count = map.getOrDefault(n, 0);
            if(count == nums.length / 2) return n;
            map.put(n, count + 1);
        }

        return -1;
    }

    public int majorityElement3(int[] nums) {
        int R = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                R = num;
                count++;
            } else if (R == num) {
                count++;
            } else {
                count--;
            }
        }

        return R;
    }
}
