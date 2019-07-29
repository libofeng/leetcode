package com.leetcode.minimax;

import java.util.HashMap;
import java.util.Map;

public class No464CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        final int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        return search(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean search(int max, int total, int state, Map<Integer, Boolean> cache) {
        if (total <= 0) return false;
        if (cache.containsKey(state)) return cache.get(state);

        for (int i = 1; i <= max; i++) {
            if ((state & (1 << i)) > 0) continue;

            if (!search(max, total - i, (state | (1 << i)), cache)) {
                cache.put(state, true);
                return true;
            }
        }

        cache.put(state, false);
        return false;
    }
}
