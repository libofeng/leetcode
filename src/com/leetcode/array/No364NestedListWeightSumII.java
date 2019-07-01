package com.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No364NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return dfs(nestedList, height(nestedList));
    }

    private int dfs(List<NestedInteger> list, int h) {
        int sum = 0;

        for (NestedInteger i : list) {
            if (i.isInteger()) sum += i.getInteger() * h;
            else sum += dfs(i.getList(), h - 1);
        }

        return sum;
    }

    private int height(List<NestedInteger> list) {
        int h = 0;
        for (NestedInteger i : list) {
            if (!i.isInteger()) h = Math.max(h, height(i.getList()));
        }

        return h + 1;
    }

    public int depthSumInverse2(List<NestedInteger> nestedList) {
        final Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger i : nestedList) q.offer(i);

        int totalSum = 0, sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NestedInteger i = q.poll();
                if (i.isInteger()) sum += i.getInteger();
                else q.addAll(i.getList());
            }

            totalSum += sum;
        }

        return totalSum;
    }
}
