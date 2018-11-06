package com.lintcode.math;

public class No656MultiplyStrings {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        final int n1 = num1.length(), n2 = num2.length();
        final int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j] += result[i + j + 1] / 10;
                result[i + j + 1] = result[i + j + 1] % 10;
            }
        }

        final StringBuilder builder = new StringBuilder();
        int start = 0;
        while (start < result.length && result[start] == 0) start++;

        for (int i = start; i < result.length; i++) builder.append(result[i]);
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
