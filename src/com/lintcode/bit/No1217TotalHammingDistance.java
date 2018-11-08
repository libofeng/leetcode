package com.lintcode.bit;

public class No1217TotalHammingDistance {
    /**
     * @param nums: the gievn integers
     * @return: the total Hamming distance between all pairs of the given numbers
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) ones++;
                nums[j] = (nums[j] >> 1);
            }
            total += ones * (n - ones);
        }

        return total;
    }
}
