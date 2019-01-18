package com.leetcode.string;

public class No273IntegerToEnglishWords {

    private final String[] BELOW_TWENTY = new String[]{
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
            "Nineteen",
    };

    private final String[] BELOW_HUNDRED = new String[]{
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

    private final String[] OVER_THOUSAND = new String[]{
            "",
            "Thousand",
            "Million",
            "Billion"
    };


    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            String next = convert(num % 1000).trim();
            if (next.length() > 0) sb.insert(0, next + " " + OVER_THOUSAND[i] + " ");
            num /= 1000;
            i++;
        }

        return sb.toString().trim();
    }

    private String convert(int num) {
        if (num < 20) return BELOW_TWENTY[num];
        if (num < 100) return BELOW_HUNDRED[num / 10] + " " + BELOW_TWENTY[num % 10];

        return BELOW_TWENTY[num / 100] + " Hundred " + convert(num % 100);
    }

    public static void main(String[] args) {
        No273IntegerToEnglishWords solution = new No273IntegerToEnglishWords();
        String english = solution.numberToWords(1000);
        System.out.println("english = " + english);
    }
}
