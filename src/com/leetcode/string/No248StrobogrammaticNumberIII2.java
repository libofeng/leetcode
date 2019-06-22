package com.leetcode.string;

public class No248StrobogrammaticNumberIII2 {
    private int total;
    private char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(low, high, 0, i - 1, new char[i]);
        }

        return total;
    }

    private void dfs(String low, String high, int left, int right, char[] chars) {
        if (left > right) {
            String s = new String(chars);
            if ((s.length() == low.length() && s.compareTo(low) < 0)
                    || (s.length() == high.length() && high.compareTo(s) < 0)) return;

            total++;
            return;
        }

        for (char[] p : pairs) {
            chars[left] = p[0];
            chars[right] = p[1];

            if (left == right && p[0] != p[1]) continue;
            if (chars.length > 1 && chars[0] == '0') continue;
            dfs(low, high, left + 1, right - 1, chars);
        }
    }
}
