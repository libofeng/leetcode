package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No187RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        final Set<String> visited = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!visited.add(sub)) repeated.add(sub);
        }

        return new ArrayList<>(repeated);
    }
}
