package com.leetcode.string;

import java.util.*;

public class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            groups.putIfAbsent(s, new ArrayList<>());
            groups.get(s).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
