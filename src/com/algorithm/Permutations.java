package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used);
        return list;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            list.add(nums[i]);
            backtrack(result, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations permutation = new Permutations();
        List<List<Integer>> list = permutation.permute(new int[]{1, 2, 3});
        System.out.println("list = " + list);
    }
}
