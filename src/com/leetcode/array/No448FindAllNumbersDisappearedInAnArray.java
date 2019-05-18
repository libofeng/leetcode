package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No448FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        final List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = 1, i = 0;
        while (i < nums.length) {
            if (n == nums[i]) {
                i++;
                n++;
            } else if (n < nums[i]) result.add(n++);
            else i++;
        }
        while (n <= nums.length) result.add(n++);

        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++) if (nums[i] > 0) list.add(i + 1);

        return list;
    }
}
