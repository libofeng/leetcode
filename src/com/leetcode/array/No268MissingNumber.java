package com.leetcode.array;

public class No268MissingNumber {
    // XOR
    public int missingNumber(int[] nums) {
        int n = nums.length, xor = n;
        for (int i = 0; i < n; i++) xor ^= i ^ nums[i];
        return xor;
    }

    // Sum
    public int missingNumber2(int[] nums) {
        int n = nums.length, sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) sum -= nums[i];
        return sum;
    }

    // Binary search
    public int missingNumber3(int[] nums) {
        return 0;
    }


    public int missingNumber4(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if ((i == 0 && index == 0) || index >= n) continue;

            if (nums[i] == 0) {
                nums[0] = -nums[0];
                nums[i] = n;
            } else if (nums[index] == 0) {
                nums[0] = -nums[0];
                nums[index] = -n;
            } else nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < n; i++) if (nums[i] > 0) return i;
        return n;
    }

    public static void main(String[] args) {
        final No268MissingNumber solution = new No268MissingNumber();
        int n = solution.missingNumber4(new int[]{0});
        System.out.println("n = " + n);
    }
}
