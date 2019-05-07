package com.company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestChain2 {
    public static void main(String[] args) {
        String[] input = {"a", "ba", "bca", "bda", "bdca"};
        LongestChain2 solution = new LongestChain2();
        System.out.println(solution.getLongestChain(input));
    }

    public int getLongestChain(String[] words) {
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            set.add(word);
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int ans = 0;
        for (String word : words) {
            Integer length = map.get(word);
            if (length == null) {
                length = dfs(word, map, set);
            }
            ans = Math.max(ans, length);
        }
        return ans;
    }

    private int dfs(String word, Map<String, Integer> map, Set<String> set) {
        Integer ans = map.get(word);
        if (ans != null) {
            return ans.intValue();
        }
        ans = 0;
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            ans = Math.max(ans, dfs(newWord, map, set) + 1);
        }
        map.put(word, ans);
        return ans.intValue();
    }
}
