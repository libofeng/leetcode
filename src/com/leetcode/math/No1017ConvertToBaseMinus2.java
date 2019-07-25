package com.leetcode.math;

public class No1017ConvertToBaseMinus2 {

    public String base2(int N) {
        if (N == 0 || N == 1) return Integer.toString(N);
        return base2(N >> 1) + Integer.toString(N & 1);
    }

    public String baseNeg2(int N) {
        if (N == 0 || N == 1) return Integer.toString(N);
        return baseNeg2(-(N >> 1)) + Integer.toString(N & 1);
    }


    public String base22(int N) {
        StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            N = N >> 1;
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }

    public String baseNeg22(int N) {
        StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            N = -(N >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }

    public String baseNeg23(int N) {
        final StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            if ((N & 1) == 1) N--;
            N /= -2;
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
