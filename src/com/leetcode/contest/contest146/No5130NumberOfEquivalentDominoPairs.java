package com.leetcode.contest.contest146;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No5130NumberOfEquivalentDominoPairs {
    // TLE
    public int numEquivDominoPairs(int[][] dominoes) {
        for(int[] nums : dominoes) Arrays.sort(nums);

        int count = 0;
        for(int i = 0;i<dominoes.length;i++){
            for(int j = i+1;j<dominoes.length;j++) if(Arrays.equals(dominoes[i], dominoes[j])) count++;
        }

        return count;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        final Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for(int[] nums : dominoes){
            int a = nums[0] * 10 + nums[1], b = nums[1] * 10 + nums[0];
            count += map.getOrDefault(a, 0);
            if(a!=b) count += map.getOrDefault(b, 0);

            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        return count;
    }
}
