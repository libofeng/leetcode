package com.leetcode.bit;

public class No393UTF8Validation {
    // https://leetcode.com/problems/utf-8-validation/discuss/87485/O(n)-JAVA-solution-with-detailed-explaination

    private final int[] masks = {128, 64, 32, 16, 8};
    private final int max = 1 << 8;

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int n = data[i];
            if (n >= max) return false;

            int type = getType(n);
            if (type == -1 || type == 1 || i + type > data.length) return false;
            else if (type == 0) continue;

            while (type-- > 1) {
                if (getType(data[++i]) != 1) return false;
            }
        }

        return true;
    }

    private int getType(int n) {
        for (int i = 0; i < masks.length; i++) if ((masks[i] & n) == 0) return i;
        return -1;
    }

    public static void main(String[] args) {
        No393UTF8Validation solution = new No393UTF8Validation();
        boolean valid = solution.validUtf8(new int[]{197, 130, 1});
        System.out.println("expected:true, valid = " + valid);

        valid = solution.validUtf8(new int[]{235, 140, 4});
        System.out.println("expected:false, valid = " + valid);
    }
}
