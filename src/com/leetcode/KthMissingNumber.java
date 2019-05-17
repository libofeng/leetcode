package com.leetcode;

public class KthMissingNumber {
    /*
    给一个已排好序的正整数数组，在首尾之间，不连续的部分可以看成是漏掉了一些数。这些漏掉的数可以组成一个虚拟的数组，要求给出一个序号k，返回虚拟数组的第k个数。
    比如给定原数组：[2,4,7,8,9,15]，漏掉的数组成这样一个虚拟数组：[3,5,6,10,11,12,13,14]。若k=2，返回虚拟数组的第二个数“5”。
     */

    public static void main(String[] args) {
        KthMissingNumber kthMissingNumber = new KthMissingNumber();
        int n = kthMissingNumber.findKthMissing(new int[]{2, 4, 7, 8, 9, 15}, 2);
        System.out.println("n = " + n + ", expected: 5");
    }

    // solution: Binary search and make 2 pointers stop at a pair of adjacent numbers.
    // if we can find the kth number from the missing numbers between the 2 pointers, return the result
    // otherwise return -1
    public int findKthMissing(int[] nums, int k) {
        if (nums == null || nums.length < 2) return -1;

        final int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2, missingCount = (nums[mid] - nums[lo]) - (mid - lo);

            if (missingCount < k) {
                lo = mid;
                k -= missingCount;
            } else hi = mid;
        }

        // the 2 pointers stop at the adjacent 2 numbers
        if (nums[lo] + k >= nums[hi]) return -1;
        return nums[lo] + k;
    }
}
