package com.leetcode.string;

public class No411MinimumUniqueWordAbbreviation {
    public String minAbbreviation(String target, String[] dictionary) {
        char[] c = target.toCharArray(), tmp = new char[c.length];

        for (int l = 1; l <= target.length(); l++) {
            String abbr = minAbbreviation(c, 0, tmp, 0, dictionary, l);
            if (abbr != null) return abbr;
        }

        return null;
    }

    private String minAbbreviation(char[] c, int start, char[] tmp, int t, String[] d, int l) {
        if (l == 0) {
            if (start == c.length && !conflict(tmp, t, d, c.length)) return new String(tmp, 0, t);
            return null;
        }

        if (t == 0 || tmp[t - 1] > '9') {
            for (int end = start + 1; end <= c.length - l; end++) {
                int len = end - start + 1;
                if (len >= 10) {
                    tmp[t] = (char) (len / 10 + '0');
                    tmp[t + 1] = (char) (len % 10 + '0');
                    String r = minAbbreviation(c, end + 1, tmp, t + 2, d, l - 1);
                    if (r != null) return r;
                } else {
                    tmp[t] = (char) (len + '0');
                    String r = minAbbreviation(c, end + 1, tmp, t + 1, d, l - 1);
                    if (r != null) return r;
                }
            }
        }

        tmp[t] = c[start];
        return minAbbreviation(c, start + 1, tmp, t + 1, d, l - 1);
    }

    private boolean conflict(char[] abbr, int t, String[] d, int l) {
        char[] pattern = new char[abbr.length];
        int p = 0, count = 0;
        for (int i = 0; i < t; i++) {
            char c = abbr[i];
            if (c <= '9') count = count * 10 + (c - '0');
            else {
                if (count != 0) {
                    pattern[p++] = (char) count;
                    count = 0;
                }
                pattern[p++] = c;
            }
        }

        for (String w : d) {
            if (w.length() != l) continue;
            int j = 0;
            boolean match = true;
            for (int i = 0; i < p; i++) {
                if (pattern[i] < 22) j += pattern[i];
                else if (w.charAt(j) != pattern[i]) {
                    match = false;
                    break;
                } else j++;
            }
            if (match) return true;
        }

        return false;
    }
}
