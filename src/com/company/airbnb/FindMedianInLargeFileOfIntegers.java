package com.company.airbnb;

public class FindMedianInLargeFileOfIntegers {
    public static void main(String[] args) {
        FindMedianInLargeFileOfIntegers solution = new FindMedianInLargeFileOfIntegers();
        assert (Double.compare(0.0, solution.findMedian(new int[]{-1, 0, 0, 0, 1})) == 0);
        assert (Double.compare(3.0, solution.findMedian(new int[]{3, -2, 7})) == 0);
        assert (Double.compare(5.0, solution.findMedian(new int[]{-100, 99, 3, 0, 5, 7, 11, 66, -33})) == 0);
        assert (Double.compare(4.5, solution.findMedian(new int[]{4, -100, 99, 3, 0, 5, 7, 11, 66, -33})) == 0);
    }

    private double findMedian(int[] nums) {
        final int n = nums.length;
        if (n % 2 == 1) return findKth(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);

        int m1 = findKth(nums, n / 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int m2 = findKth(nums, n / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return (m1 + m2) / 2.0D;
    }

    private int findKth(int[] nums, int k, long min, long max) {
        if (min >= max) return (int) min;

        while (min < max) {
            long mid = min + (max - min) / 2, leftMax = min, smallCount = 0;
            for (int n : nums) {
                if (n <= mid) {
                    smallCount++;
                    leftMax = Math.max(n, leftMax);
                }
            }

            if (smallCount == k) return (int) leftMax;
            else if (smallCount < k) min = Math.max(leftMax + 1, mid);
            else max = leftMax;
        }

        return (int) min;
    }
}
