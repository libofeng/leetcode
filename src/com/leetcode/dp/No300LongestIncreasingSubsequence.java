package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class No300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public int lengthOfLIS2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : nums) {
            int index = findIndex(list, n);
            if (index >= list.size()) list.add(n);
            else list.set(index, n);
        }

        return list.size();
    }

    // https://blog.csdn.net/LxcXingC/article/details/81238008
    // 从LIS的性质出发，要想得到一个更长的上升序列，该序列前面的数必须尽量的小。

    // 对于序列1,5,8,3,6,7来说，当子序列为1,5,8时，遇到3时，序列已经不能继续变长了。
    // 但是，我们可以通过替换，使“整个序列”看上去更小，从而有更大的机会去变长。
    // 这样，当替换5-3和替换8-6完成后（此时序列为1,3,6），我们可以在序列末尾添加一个7了。

    // 那为什么复杂度可以是O(NlogN)呢？

    // 关键就在“替换”这一步上，若直接遍历序列替换，每次替换都要O(N)的时间。
    // 但是只要我们再次利用LIS的性质——序列是有序的（单调的），就可以用二分查找，在O(logN)的时间内完成一次替换，所以算法的复杂度是O(NlogN)的。
    private int findIndex(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid;
        }

        return l;
    }
}
