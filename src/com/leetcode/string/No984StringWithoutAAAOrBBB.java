package com.leetcode.string;

public class No984StringWithoutAAAOrBBB {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A > 0 || B > 0) {
            if (A > B) {
                if (A-- > 0) sb.append('a');
                if (A-- > 0) sb.append('a');
                if (B-- > 0) sb.append('b');
            } else if (B > A) {
                if (B-- > 0) sb.append('b');
                if (B-- > 0) sb.append('b');
                if (A-- > 0) sb.append('a');
            } else {
                if (A-- > 0) sb.append('a');
                if (B-- > 0) sb.append('b');
            }
        }

        return sb.toString();
    }
}
