package com.leetcode.array;

public class No66PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i] + carry;
            digits[i] = n % 10;
            carry = n / 10;
        }

        if (carry == 0) return digits;
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] == 9 ? 0 : digits[i] + 1;
            if (digits[i] != 0) return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
