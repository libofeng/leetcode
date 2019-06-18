package com.leetcode.brainteaser;

import java.util.BitSet;

public class No292NimGame {
    // TLE
    // Time: O(3^N), Space: O(N)
    public boolean canWinNim(int n) {
        if (n <= 3) return true;

        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
    }

    // TLE
    // Time: O(N), Space: O(N)
    public boolean canWinNim2(int n) {
        final BitSet dp = new BitSet(n + 1);
        for (int i = 0; i <= n; i++) {
            if (i <= 3 || !(dp.get(i - 1) && dp.get(i - 2) && dp.get(i - 3))) dp.set(i);
        }

        return dp.get(n);
    }

    // https://leetcode.com/problems/nim-game/discuss/73760/One-line-O(1)-solution-and-explanation
    public boolean canWinNim3(int n) {
        return n % 4 != 0;
    }
}
