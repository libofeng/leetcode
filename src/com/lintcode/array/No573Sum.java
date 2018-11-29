package com.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No573Sum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        final List<List<Integer>> R = new ArrayList<>();
        if (numbers.length < 3) return R;
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;

            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == -numbers[i]) {
                    R.add(Arrays.asList(numbers[i], numbers[left++], numbers[right--]));

                    while (left < right && numbers[left] == numbers[left - 1]) left++;
                    while (left < right && numbers[right] == numbers[right + 1]) right--;
                } else if (numbers[left] + numbers[right] > -numbers[i]) {
                    right--;
                    while (left < right && numbers[right] == numbers[right + 1]) right--;
                } else {
                    left++;
                    while (left < right && numbers[left] == numbers[left - 1]) left++;
                }
            }
        }

        return R;
    }
}
