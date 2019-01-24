package com.leetcode.string;

public class No67AddBinary {
    public String addBinary(String a, String b) {
        final int BASE = 2;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i < 0 ? 0 : (a.charAt(i) - '0');
            int n2 = j < 0 ? 0 : (b.charAt(j) - '0');

            int n = n1 + n2 + carry;
            sb.append(n % BASE);
            carry /= BASE;
        }
        if (carry > 0) sb.append(1);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No67AddBinary solution = new No67AddBinary();
        String result = solution.addBinary("11", "1");
        System.out.println("result = " + result);
    }
}
