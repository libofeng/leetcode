package com.leetcode;

public class No157ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        int index = 0;
        char[] buffer = new char[4];
        while (index < n) {
            int k = read4(buffer);
            for (int i = 0; i < k && index < n; i++) buf[index++] = buffer[i];
            if (k < 4) break;
        }

        return index;
    }

    private int read4(char[] buf) {
        return 0;
    }
}