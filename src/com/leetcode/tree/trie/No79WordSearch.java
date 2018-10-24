package com.leetcode.tree.trie;

public class No79WordSearch {
    public boolean exist(char[][] board, String word) {
        final TrieTree tree = new TrieTree();
        tree.insert(word);

        final int m = board.length, n = board[0].length;
        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) if (dfs(board, visited, tree, "", i, j)) return true;
        }

        return false;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(char[][] B, boolean[][] V, TrieTree T, String S, int i, int j) {
        final int m = B.length, n = B[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || V[i][j]) return false;

        S += B[i][j];
        if (T.search(S)) return true;
        else if (!T.startsWith(S)) return false;

        V[i][j] = true;
        for (int[] dir : dirs) if (dfs(B, V, T, S, i + dir[0], j + dir[1])) return true;
        V[i][j] = false;

        return false;
    }
}
