package com.leetcode.string;

public class No12IntegerToRoman {
    public String intToRoman(int num) {
        final String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] radix = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < symbol.length && num > 0; i++) {
            int count = num / radix[i];
            num = num % radix[i];

            for (int j = 0; j < count; j++) builder.append(symbol[i]);
        }

        return builder.toString();
    }
}
