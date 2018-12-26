package com.leetcode.math;

public class No43MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0', n2 = num2.charAt(j) - '0';
                result[i + j + 1] += n1 * n2;
                result[i + j] += result[i + j + 1] / 10;
                result[i + j + 1] = result[i + j + 1] % 10;
            }
        }

        int start = 0;
        while (start < result.length && result[start] == 0) start++;
        if (start == result.length) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < result.length; i++) sb.append(result[i]);
        return sb.toString();
    }
}
