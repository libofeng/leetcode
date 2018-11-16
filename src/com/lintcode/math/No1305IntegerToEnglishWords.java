package com.lintcode.math;

public class No1305IntegerToEnglishWords {
    /**
     * @param num: a non-negative integer
     * @return: english words representation
     */
    private static String[] BELOW_TWENTY = new String[]{
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    private static String[] BELOW_HUNDRED = new String[]{
            "",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    private static String[] OVER_THOUSAND = new String[]{
            "",
            "Thousand",
            "Million",
            "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        final StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num != 0) {
            String pre = helper(num % 1000).trim();
            sb.insert(0, pre + " " + OVER_THOUSAND[i++] + " ");
            num /= 1000;
        }

        return sb.toString().trim();
    }

    public String helper(int n) {
        String s;
        if (n < 20) s = BELOW_TWENTY[n];
        else if (n < 100) s = BELOW_HUNDRED[n / 10] + " " + BELOW_TWENTY[n % 10];
        else s = BELOW_TWENTY[n / 100] + " Hundred " + helper(n % 100);

        return s.trim();
    }
}
