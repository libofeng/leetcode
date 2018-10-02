package com.leetcode.string;

public class No67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0, ai = a.length(), bi = b.length(), len = Math.max(ai, bi);

        while (len-- > 0) {
            int na = 0, nb = 0;
            if (ai > 0) {
                na = a.charAt(ai - 1) - '0';
                ai--;
            }
            if (bi > 0) {
                nb = b.charAt(bi - 1) - '0';
                bi--;
            }

            int n = na + nb + carry;
            carry = n / 2;
            builder.append(n % 2);
        }
        if (carry > 0) builder.append(carry);

        return builder.reverse().toString();
    }
}
