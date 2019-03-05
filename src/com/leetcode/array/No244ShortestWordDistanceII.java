package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No244ShortestWordDistanceII {
    // https://www.cnblogs.com/lightwindy/p/9736294.html
    // https://www.cnblogs.com/immiao0319/p/9374874.html

    private Map<String, List<Integer>> indexList = new HashMap<>();

    // Space complexity: O(N)
    public No244ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            indexList.putIfAbsent(w, new ArrayList<>());
            indexList.get(w).add(i);
        }
    }

    // Time complexity: O(N)
    public int shortestDistance(String word1, String word2) {
        int d = Integer.MAX_VALUE, i = 0, j = 0;
        final List<Integer> list1 = indexList.get(word1);
        final List<Integer> list2 = indexList.get(word2);

        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i), index2 = list2.get(j);
            d = Math.min(d, Math.abs(index1 - index2));

            if (index1 < index2) i++;
            else j++;
        }

        return d;
    }

    public static void main(String[] args) {
        final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        No244ShortestWordDistanceII solution = new No244ShortestWordDistanceII(words);
        int d = solution.shortestDistance("coding", "practice");
        System.out.println("passed=" + (d == 3));

        d = solution.shortestDistance("makes", "coding");
        System.out.println("passed=" + (d == 1));
    }
}
