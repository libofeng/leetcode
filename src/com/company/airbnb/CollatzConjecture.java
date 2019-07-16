package com.company.airbnb;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {
    /*
    Collatz Conjecture
    3n+1猜想
    输入一个大于1自然数n，若n为奇数，则将n变为3n+1,否则变为n的一半。经过若干次这样的变化，一定会使n变为1。
    https://en.wikipedia.org/wiki/Collatz_conjecture
     */

    public static void main(String[] args) {
        CollatzConjecture solution = new CollatzConjecture();
        int steps;


        steps = solution.findLongestSteps(1);
        assert (steps == 1);
        steps = solution.findLongestSteps(10);
        assert (steps == 20);
        steps = solution.findLongestSteps(37);
        assert (steps == 112);
        steps = solution.findLongestSteps(101);
        assert steps == 119;
    }

    private int findSteps(int n) {
        if (n <= 1) return 1;
        return ((n & 1) == 1 ? findSteps(3 * n + 1) : findSteps(n / 2)) + 1;
    }

    private int findStepsWithCache(int n, Map<Integer, Integer> cache) {
        if (n <= 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        int steps = ((n & 1) == 1 ? findSteps(3 * n + 1) : findSteps(n / 2)) + 1;
        cache.put(n, steps);
        return steps;
    }

    private int findLongestSteps(int n) {
        if (n < 1) return 0;
        final Map<Integer, Integer> cache = new HashMap<>();

        int maxCount = 0;
        for (int i = 1; i <= n; i++) maxCount = Math.max(maxCount, findStepsWithCache(i, cache));

        return maxCount;
    }
}
