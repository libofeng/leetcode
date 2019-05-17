package com.leetcode;

public class KthMissingNumber {
    /*
    给一个已排好序的正整数数组，在首尾之间，不连续的部分可以看成是漏掉了一些数。这些漏掉的数可以组成一个虚拟的数组，要求给出一个序号k，返回虚拟数组的第k个数。
    比如给定原数组：[2,4,7,8,9,15]，漏掉的数组成这样一个虚拟数组：[3,5,6,10,11,12,13,14]。若k=2，返回虚拟数组的第二个数“5”。
     */

    public int findKthMissing(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int all = (nums[mid] - nums[left] + 1) - (mid - left + 1);
            if (k > all) {
                k -= all;
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] + k >= nums[right]) {
            return -1;
        } else {
            return nums[left] + k;
        }
    }
}
