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
}
