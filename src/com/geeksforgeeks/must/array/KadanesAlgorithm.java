package com.geeksforgeeks.must.array;

public class KadanesAlgorithm {

    private int maxSubArraySum(int[] nums) {
        int sum = 0, maxSum = 0;
        for (int n : nums) {
            if (sum <= 0) sum = n;
            else sum += n;

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};

        KadanesAlgorithm solution = new KadanesAlgorithm();
        int maxSum = solution.maxSubArraySum(nums);
        System.out.println("maxSum = " + maxSum);
    }
}
