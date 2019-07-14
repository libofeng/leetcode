package com.leetcode.array;

import java.util.Arrays;

public class No475Heaters {
    // https://leetcode.com/problems/heaters/discuss/95886/Short-and-Clean-Java-Binary-Search-Solution
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index >= 0) continue;

            index = -(index + 1);
            int dist1 = index == 0 ? Integer.MAX_VALUE : house - heaters[index - 1];
            int dist2 = index == heaters.length ? Integer.MAX_VALUE : heaters[index] - house;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
