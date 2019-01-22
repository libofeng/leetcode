package com.leetcode;

public class No158ReadNCharactersGivenRead4IICallMultipleTimes {
    private static final int N = 4;
    private char[] buffer = new char[N];
    private int bufferStart = 0, bufferEnd = 0;

    public int read(char[] buf, int n) {
        int index = 0;
        for (; bufferStart < bufferEnd && index < n; bufferStart++) buf[index++] = buffer[bufferStart];
        while (index < n) {
            bufferStart = 0;
            bufferEnd = read4(buffer);
            for (; bufferStart < bufferEnd && index < n; bufferStart++) buf[index++] = buffer[bufferStart];
            if (bufferEnd < N) break;
        }

        return index;
    }

    private int read4(char[] buffer) {
        return 0;
    }
}
