package com.lintcode.string;

public class No13ImplementStrStr {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        if (target.length() == 0) return 0;

        final int ls = source.length(), lt = target.length();
        for (int i = 0; i <= ls - lt; i++) {
            if (source.charAt(i) != target.charAt(0)) continue;

            int j = 0;
            for (; j < lt; j++) if (source.charAt(i + j) != target.charAt(j)) break;
            if (j == lt) return i;
        }

        return -1;
    }
}
