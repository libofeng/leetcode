package com.leetcode.contest.contest135;

import java.util.Arrays;

public class No5049MovingStonesUntilConsecutiveII {
    /*
    On an infinite number line, the position of the i-th stone is given by stones[i].  Call a stone an endpoint stone if it has the smallest or largest position.

    Each turn, you pick up an endpoint stone and move it to an unoccupied position so that it is no longer an endpoint stone.

    In particular, if the stones are at say, stones = [1,2,5], you cannot move the endpoint stone at position 5, since moving it to any position (such as 0, or 3) will still keep that stone as an endpoint stone.

    The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.

    When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
     */

    // https://www.youtube.com/watch?v=d9FFzpP9GLk
    public int[] numMovesStonesII(int[] stones) {
        final int n = stones.length;
        Arrays.sort(stones);
        int i = 0, min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            while (stones[j] - stones[i] >= n) i++;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) min = Math.min(min, 2);
            else min = Math.min(min, n - (j - i + 1));
        }

        int max = Math.max(stones[n - 1] - stones[1], stones[n - 2] - stones[0]) - (n - 2);
        return new int[]{min, max};
    }
}
