package com.lintcode.string;

import java.util.*;

public class No772GroupAnagrams {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.putIfAbsent(key, new LinkedList<>());
            groups.get(key).add(str);
        }

        List<List<String>> R = new LinkedList<>();
        R.addAll(groups.values());

        return R;
    }
}
