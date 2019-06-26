package com.leetcode.backtracking;

import java.math.BigInteger;

public class No306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;

        final BigInteger[] nums = new BigInteger[num.length()];
        return dfs(num, 0, nums, 0);
    }

    private boolean dfs(String num, int start, BigInteger[] nums, int index) {
        if (start == num.length()) return index > 2;

        if (index >= 2) {
            BigInteger sum = nums[index - 1].add(nums[index - 2]);
            String s = sum.toString();
            if (num.substring(start).startsWith(s)) {
                nums[index] = sum;
                return dfs(num, start + s.length(), nums, index + 1);
            }

            return false;
        }

        for (int i = start; i < num.length(); i++) {
            if (i > start && num.charAt(start) == '0') continue;

            BigInteger n = new BigInteger(num.substring(start, i + 1));
            nums[index] = n;
            if (dfs(num, i + 1, nums, index + 1)) return true;
        }

        return false;
    }
}
