package com.leetcode.contest.contest124;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No996NumberOfSquarefulArrays {
    private int count = 0;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        dfs(A, new boolean[A.length], new ArrayList<>());

        return count;
    }

    private void dfs(int[] A, boolean[] used, List<Integer> list) {
        if (list.size() == A.length) {
            count++;
            return;
        }

        Integer last = null;
        for (int i = 0; i < A.length; i++) {
            if (used[i] || (last != null && last == A[i])) continue;
            if (list.size() > 0 && !isPerfectSquare(list.get(list.size() - 1), A[i])) continue;

            used[i] = true;
            list.add(A[i]);
            last = A[i];

            dfs(A, used, list);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    private boolean isPerfectSquare(int x, int y) {
        int sum = x + y, sqrt = (int) Math.sqrt(sum);
        return sqrt * sqrt == sum;
    }
}
