package com.company.google;

import java.util.*;

public class LongestChain {
    public static void main(String[] args) {
        String[] input = {"a", "ba", "bca", "bda", "bdca"};
        LongestChain solution = new LongestChain();
        System.out.println(solution.getLongestChain(input));
    }

    private int getLongestChain(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
        for (String word : words) {
            Set<String> set = map.get(word.length());
            if (set == null) {
                set = new HashSet<String>();
                map.put(word.length(), set);
            }
            set.add(word);
        }
        int ans = 0;
        List<Integer> lengthList = new ArrayList<Integer>(map.keySet());
        Collections.sort(lengthList, Collections.reverseOrder());
        return helper(0, lengthList, map, "");
    }

    private int helper(int start, List<Integer> list, Map<Integer, Set<String>> map, String prev) {
        if (start == list.size()) {
            return 0;
        }
        int ans = 0;
        if (start == 0) {
            for (String word : map.get(list.get(0))) {
                ans = Math.max(ans, helper(start + 1, list, map, word) + 1);
            }
        } else if (prev.length() - 1 == list.get(start)) {
            Set<String> wordSet = map.get(list.get(start));
            for (int i = 0; i < prev.length(); i++) {
                String newWord = prev.substring(0, i) + prev.substring(i + 1);
                if (wordSet.contains(newWord)) {
                    wordSet.remove(newWord);
                    ans = Math.max(ans, helper(start + 1, list, map, newWord) + 1);
                }
            }
        }
        return ans;
    }
}