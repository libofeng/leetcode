package com.leetcode.string;

public class No214ShortestPalindrome {
    // Timeout
    public String shortestPalindrome(String s) {
        String head = "";
        int p = s.length();
        while (!isPalindrome(head + s)) {
            head = head + s.charAt(--p);
        }

        return head + s;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    // O(N*N)
    public String shortestPalindrome2(String s) {
        int end = s.length() - 1;
        while (!isPalindrome(s, end)) end--;

        StringBuilder sb = new StringBuilder();
        if (end < s.length() - 1) sb.append(s.substring(end + 1));
        sb.reverse();
        sb.append(s);

        return sb.toString();
    }

    private boolean isPalindrome(String s, int end) {
        int l = 0, r = end;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    // O(N^2)
    // TLE
    public String shortestPalindrome3(String s) {
        final int n = s.length();
        final boolean[][] dp = new boolean[n][n];

        int maxI = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) maxI = i;
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > maxI; i--) sb.append(s.charAt(i));
        sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        No214ShortestPalindrome solution = new No214ShortestPalindrome();
        String p = solution.shortestPalindrome3("aacecaaa");
        System.out.println("p = " + p + ", matched? " + "aaacecaaa".equals(p));
    }
}
