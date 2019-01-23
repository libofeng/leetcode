package com.lintcode.math;

public class No168ExcelSheetColumnTitle {

    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        return n-- == 0 ? "" : convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }

    public String convertToTitle2(int n) {
        final StringBuilder builder = new StringBuilder();
        while (n-- > 0) {
            builder.append((char) (n % 26 + 'A'));
            n /= 26;
        }

        return builder.reverse().toString();
    }
}
