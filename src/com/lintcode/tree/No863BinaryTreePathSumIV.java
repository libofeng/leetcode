package com.lintcode.tree;

import java.util.HashMap;
import java.util.Map;

public class No863BinaryTreePathSumIV {
    /**
     * @param nums: a list of integers
     * @return: return an integer
     */
    private Map<Integer, Integer> map;
    private int sum = 0;

    public int pathSum(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) map.put(num / 10, num % 10);
        helper(nums[0] / 10, nums[0] % 10);
        return sum;
    }

    private void helper(int root, int currSum) {
        int left = (root / 10 + 1) * 10 + (root % 10) * 2 - 1;
        int right = (root / 10 + 1) * 10 + (root % 10) * 2;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            sum += currSum;
            return;
        }
        if (map.containsKey(left)) helper(left, currSum + map.get(left));
        if (map.containsKey(right)) helper(right, currSum + map.get(right));
    }
}
