package com.lintcode.math;

public class No1398KDecimalAddition {
    /**
     * @param k: The k
     * @param a: The A
     * @param b: The B
     * @return: The answer
     */
    public String addition(int k, String a, String b) {
        int carry = 0;
        final StringBuilder sb = new StringBuilder();

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0, n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append((n1 + n2 + carry) % k);
            carry = (n1 + n2 + carry) / k;
        }

        if (carry > 0) sb.append(carry);
        while(sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
