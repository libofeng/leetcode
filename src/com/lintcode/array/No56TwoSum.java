package com.lintcode.array;

import java.util.HashMap;
import java.util.Map;

public class No56TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (map.containsKey(key)) return new int[]{map.get(key), i};
            else map.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }
}
