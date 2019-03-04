package com.leetcode.array;

import java.util.stream.IntStream;

public class No453MinimumMovesToEqualArrayElements {
    // https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93815/Java-O(n)-solution.-Short.
    /*
    Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
    So, best way to do this is make all the elements in the array equal to the min element.
            sum(array) - n * minimum
     */

    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }

    public int minMoves2(int[] nums) {
        return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
    }
}
