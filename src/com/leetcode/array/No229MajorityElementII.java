package com.leetcode.array;

import java.util.*;

public class No229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);

        List<Integer> R = new ArrayList<>();
        int counter = 0, num = 0;

        for (int n : nums) {
            if (counter == 0) {
                num = n;
                counter++;
            } else if (n == num) {
                counter++;
            } else {
                if (counter > nums.length / 3) R.add(num);
                num = n;
                counter = 1;
            }
        }
        if (counter > nums.length / 3) R.add(num);

        return R;
    }

    public List<Integer> majorityElement2(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);

        List<Integer> R = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > nums.length / 3) R.add(entry.getKey());
        }

        return R;
    }

    public List<Integer> majorityElement3(int[] nums) {
        List<Integer> R = new ArrayList<>();
        if (nums == null || nums.length == 0) return R;

        int A = nums[0], B = nums[0], countA = 0, countB = 0;

        for (int num : nums) {
            if (A == num) countA++;
            else if (B == num) countB++;
            else if (countA == 0) {
                A = num;
                countA++;
            } else if (countB == 0) {
                B = num;
                countB++;
            } else {
                countA--;
                countB--;
            }
        }

        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == A) countA++;
            else if (num == B) countB++;
        }

        if (countA > nums.length / 3) R.add(A);
        if (countB > nums.length / 3) R.add(B);

        return R;
    }
}
