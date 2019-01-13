package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combination(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination solution = new Combination();
        List<List<Integer>> combination = solution.combination(new int[]{1, 2, 3});
        System.out.println("combination = " + combination);
    }
}
