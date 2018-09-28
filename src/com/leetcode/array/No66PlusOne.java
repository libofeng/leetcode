package com.leetcode.array;

public class No66PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        newDigits[0] = 1;

        return newDigits;
    }
}
