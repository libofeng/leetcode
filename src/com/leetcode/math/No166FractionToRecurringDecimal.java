package com.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class No166FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 1) return numerator + "";

        final StringBuilder sb = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0)) sb.append("-");

        long num = Math.abs(numerator), den = Math.abs(denominator);
        sb.append(Math.abs(num / den));

        num = 10 * (num % den);
        if (num == 0) return sb.toString();

        sb.append(".");
        final StringBuilder fraction = new StringBuilder();
        final Map<Long, Integer> visited = new HashMap<>();
        visited.put(num, fraction.length());

        while (num != 0) {
            fraction.append(Math.abs(num / den));
            num = 10 * (num % den);

            if (visited.containsKey(num)) {
                sb.append(fraction.substring(0, visited.get(num)));
                sb.append('(');
                sb.append(fraction.substring(visited.get(num)));
                sb.append(')');
                return sb.toString();
            }
            visited.put(num, fraction.length());
        }

        sb.append(fraction.toString());
        return sb.toString();
    }
}
