package com.company.indeed;

public class LocalMinimum {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[mid + 1]) hi = mid;
            else lo = mid + 1;
        }

        return nums[lo];
    }

    public static void main(String[] args) {
        LocalMinimum solution = new LocalMinimum();
        int min = solution.findMin(new int[]{8, 5, 3, 6, 1, 4, 7});
        System.out.println("min = " + min);
    }
}
