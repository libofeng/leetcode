package com.leetcode.contest.biweekly.contest7;

import java.util.HashMap;
import java.util.Map;

public class No1166DesignFileSystem {

    private Map<String, Integer> paths = new HashMap<>();

    public No1166DesignFileSystem() {

    }

    public boolean create(String path, int value) {
        if (path.length() < 2 || !path.startsWith("/")) return false;

        for (int i = 2; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                String parentPath = path.substring(0, i);
                if (!paths.containsKey(parentPath)) return false;
            }
        }

        boolean result = !paths.containsKey(path);
        paths.put(path, value);

        return result;
    }

    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}
