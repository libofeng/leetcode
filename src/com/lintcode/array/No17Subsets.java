package com.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No17Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> R = new ArrayList<>();

        dfs(nums, R, 0, new LinkedList<>());
        return R;
    }

    private void dfs(int[] nums, List<List<Integer>> R, int start, LinkedList<Integer> list) {
        R.add(new ArrayList<>(list));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, R, i + 1, list);
            list.removeLast();
        }
    }
}
