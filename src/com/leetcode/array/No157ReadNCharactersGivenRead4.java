package com.leetcode.array;

public class No157ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        final char[] buffer = new char[4];
        int index = 0;
        while (index < n) {
            int len = read4(buffer), copyLen = Math.min(n - index, len);
            System.arraycopy(buffer, 0, buf, index, copyLen);

            index += copyLen;
            if (len < 4) break;
        }

        return index;
    }

    private int read4(char[] buffer) {
        return 0;
    }
}
