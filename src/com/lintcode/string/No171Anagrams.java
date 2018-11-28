package com.lintcode.string;

import java.util.*;

public class No171Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        final Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.putIfAbsent(key, new LinkedList<>());
            groups.get(key).add(str);
        }

        final List<String> R = new LinkedList<>();
        for (List<String> group : groups.values()) if (group.size() > 1) R.addAll(group);

        return R;
    }
}
