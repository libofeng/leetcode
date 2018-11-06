package com.lintcode.array;

public class No660ReadNCharactersGivenRead4ICallMultipleTimes {
    int read4(char[] buf) {
        return 0;
    }

    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    final char[] buffer = new char[4];
    int bufferStart = 0, bufferEnd = 0;

    public int read(char[] buf, int n) {
        int index = 0;
        for (int i = bufferStart; i < bufferEnd && index < n; i++) buf[index++] = buffer[i];

        while (index < n) {
            bufferStart = 0;
            bufferEnd = read4(buffer);

            for (; bufferStart < bufferEnd && index < n; bufferStart++) buf[index++] = buffer[bufferStart];
            if (bufferEnd < 4) break;
        }

        return index;
    }
}
