package com.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

public class No190ReverseBits {
    // https://leetcode.com/problems/reverse-bits/discuss/54746/Java-Solution-and-Optimization

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits2(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            num = (num << 1) | (n & 1);
            n >>>= 1;
        }

        return num;
    }

    // How to optimize if this function is called multiple times? We can divide an int into 4 bytes, and reverse each byte then combine into an int. For each byte, we can use cache to improve performance.

    // cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits3(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) // convert int into 4 bytes
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3)
                result <<= 8;
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b); // first look up from cache
        if (value != null)
            return value;
        value = 0;
        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
}
