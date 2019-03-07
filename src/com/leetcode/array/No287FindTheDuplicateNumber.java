package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No287FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) if (nums[i] == nums[j]) return nums[i];
        }

        return -1;
    }

    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) if (nums[i] == nums[i - 1]) return nums[i];
        return -1;
    }

    public int findDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) if (!set.add(n)) return n;

        return -1;
    }

    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72844/Two-Solutions-(with-explanation)%3A-O(nlog(n))-and-O(n)-time-O(1)-space-without-changing-the-input-array
    public static int findDuplicate4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) if (num <= mid) count++;

            if (count > mid) high = mid;
            else low = mid + 1;
        }
        return low;
    }


    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72845/Java-O(n)-time-and-O(1)-space-solution.-Similar-to-find-loop-in-linkedlist.
    public int findDuplicate5(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        } while (slow != fast);
        slow = n;
        while (slow != fast) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }


    public int findDuplicate6(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n] < 0) return n;
            else nums[n] = -nums[n];
        }

        return -1;
    }
}
