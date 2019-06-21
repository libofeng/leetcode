package com.leetcode.geometry;

public class No223RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (C - A) * (D - B), b = (G - E) * (H - F);
        if (E > C || F > D || A > G || B > H) return a + b;

        int c = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        return a + b - c;
    }
}
