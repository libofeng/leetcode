package com.leetcode.math;

public class No415AddStrings {
    public String addStrings(String num1, String num2) {
        final int len1 = num1.length(), len2 = num2.length();

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;

            int n = n1 + n2 + carry;
            sb.append(n % 10);
            carry = n / 10;
        }
        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
