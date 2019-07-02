package com.leetcode.array;

public class No390EliminationGame {
    // Time: O(LogN)
    public int lastRemaining(int n) {
        int head = 1, gap = 1;

        boolean fromLeft = true;
        while (n > 1) {
            if (fromLeft || n % 2 == 1) head += gap;

            n -= (n + 1) / 2;
            fromLeft = !fromLeft;
            gap *= 2;
        }

        return head;
    }
}
