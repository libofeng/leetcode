package com.lintcode.bit;

public class No408AddBinary {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        final StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0) {
            char c1 = i >= 0 ? a.charAt(i--) : '0', c2 = j >= 0 ? b.charAt(j--) : '0';
            int n = (c1 - '0') + (c2 - '0') + carry;
            carry = n / 2;

            builder.append(n % 2);
        }
        if (carry > 0) builder.append(carry);

        return builder.reverse().toString();
    }
}
