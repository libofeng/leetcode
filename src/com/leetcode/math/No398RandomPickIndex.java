package com.leetcode.math;

import java.util.*;

public class No398RandomPickIndex {

    final Map<Integer, List<Integer>> map = new HashMap<>();
    final Random rnd = new Random();

    public No398RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indexs = map.get(target);
        return indexs.get(rnd.nextInt(indexs.size()));
    }

}
