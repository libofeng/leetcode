package com.leetcode.array;

public class No414ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (Integer n : nums) {
            if (n.equals(first) || n.equals(second) || n.equals(third)) continue;

            if (first == null || n >= first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n >= second) {
                third = second;
                second = n;
            } else if (third == null || n >= third) third = n;
        }

        return third == null ? first : third;
    }

    public int thirdMax2(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for (int n : nums) {
            if (n == first || n == second || n == third) continue;

            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) third = n;
        }

        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}
