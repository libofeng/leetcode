package com.leetcode.dfs;

public class No306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') continue;
            for (int j = i + 1; j < num.length(); j++) {
                if (j - i > 1 && num.charAt(i) == '0') continue;
                if (dfs(num, 0, i, j)) return true;
            }
        }

        return false;
    }

    private boolean dfs(String num, int i, int j, int k) {
        final long n1 = Long.parseLong(num.substring(i, j)), n2 = Long.parseLong(num.substring(j, k));
        String n = String.valueOf(n1 + n2);
        if (!num.substring(k).startsWith(n)) return false;

        if (k + n.length() == num.length()) return true;
        else return dfs(num, j, k, k + n.length());
    }
}
