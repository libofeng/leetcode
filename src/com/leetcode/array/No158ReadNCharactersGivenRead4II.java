package com.leetcode.array;

public class No158ReadNCharactersGivenRead4II {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    private char[] buffer = new char[4];
    private int start = 0, end = 0;

    public int read(char[] buf, int n) {
        int index = 0;
        for (; start < end && index < n; start++) buf[index++] = buffer[start];
        while (index < n) {
            start = 0;
            end = read4(buffer);
            for (; start < end && index < n; start++) buf[index++] = buffer[start];

            if (end < 4) break;
        }

        return index;
    }

    private int read4(char[] buffer) {
        return 0;
    }
}
