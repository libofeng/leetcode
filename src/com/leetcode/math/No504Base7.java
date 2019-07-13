package com.leetcode.math;

public class No504Base7 {
    public String convertToBase7(int num) {
        String sign = num < 0 ? "-" : "";
        num = Math.abs(num);
        return sign + (num < 7 ? ("" + num) : (convertToBase7(num / 7) + num % 7));
    }

    public String convertToBase72(int num) {
        String sign = num < 0 ? "-" : "";
        long n = Math.abs((long) num);

        final StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 7);
            n /= 7;
        }
        sb.append(sign);

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
