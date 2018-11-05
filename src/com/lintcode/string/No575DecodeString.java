package com.lintcode.string;

public class No575DecodeString {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        return process(s);
    }

    private int index = 0;

    private String process(String s) {
        StringBuilder builder = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            while (index < s.length() && Character.isLetter(s.charAt(index))) {
                builder.append(s.charAt(index++));
            }

            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index++) - '0');
            }

            if (index < s.length() && s.charAt(index) == '[') {
                index++;
                String str = process(s);
                for (int i = 0; i < num; i++) builder.append(str);
            }
        }

        index++;
        return builder.toString();
    }
}
