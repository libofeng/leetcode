package com.lintcode.string;

public class No13ImplementStrStr {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        if (target.isEmpty()) return 0;

        for (int i = 0; i <= source.length() - target.length(); i++) {
            int j = 0;
            for (; j < target.length(); j++) if (source.charAt(i + j) != target.charAt(j)) break;
            if (j == target.length()) return i;
        }

        return -1;
    }
}
