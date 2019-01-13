package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    // 47 Permutations II (contains duplicates)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // this is the key step to avoid duplicated item
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue; // avoid duplicated

            used[i] = true;
            list.add(nums[i]);
            backtrack(result, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
