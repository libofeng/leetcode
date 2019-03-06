package com.leetcode.tree.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No212WordSearchII {
    // Very important, read this article.
    // https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    public List<String> findWords(char[][] board, String[] words) {
        final Set<String> R = new HashSet<>();
        final int m = board.length, n = board[0].length;
        final boolean[][] visited = new boolean[m][n];
        final TrieTree tree = new TrieTree();

        for (String w : words) tree.insert(w);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) dfs(board, visited, tree, R, "", i, j);
        }

        return new ArrayList<>(R);
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] B, boolean[][] V, TrieTree T, Set<String> R, String S, int x, int y) {
        final int m = B.length, n = B[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || V[x][y]) return;

        S += B[x][y];
        if (T.search(S)) {
            R.add(S);
        } else if (!T.startsWith(S)) return;

        V[x][y] = true;
        for (int[] dir : dirs) dfs(B, V, T, R, S, x + dir[0], y + dir[1]);
        V[x][y] = false;
    }
}
