package com.leetcode.contest.contest140;

import java.util.HashSet;
import java.util.Set;

public class No5087LetterTilePossibilities {
    private int count = 0;

    public int numTilePossibilities(String tiles) {
        dfs(tiles, new boolean[tiles.length()], new HashSet<>(), "");
        return count;
    }

    private void dfs(String tiles, boolean[] used, Set<String> visited, String path) {
        if (!path.isEmpty() && visited.add(path)) count++;

        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(tiles, used, visited, path + tiles.charAt(i));
            used[i] = false;
        }
    }
}
