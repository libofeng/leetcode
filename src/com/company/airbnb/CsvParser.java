package com.company.airbnb;

import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static void main(String[] args) {
        CsvParser solution = new CsvParser();
        String test = "John,Smith,john.smith@gmail.com,Los Angeles,1";
        String expected = "John|Smith|john.smith@gmail.com|Los Angeles|1";
        assert (expected.equals(solution.parseCSV(test)));

        test = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
        expected = "Jane|Roberts|janer@msn.com|San Francisco, CA|0";
        assert (expected.equals(solution.parseCSV(test)));

        test = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
        expected = "Alexandra \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1";
        assert (expected.equals(solution.parseCSV(test)));

        test = "\"\"\"Alexandra Alex\"\"\"";
        expected = "\"Alexandra Alex\"";
        assert (expected.equals(solution.parseCSV(test)));
    }

    /*
    Parse an escaped string into csvformat

    Input: csvformat
    John,Smith,john.smith@gmail.com,Los Angeles,1
    Jane,Roberts,janer@msn.com,"San Francisco, CA",0
    "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1 """Alexandra Alex"""
    Output: escaped string
    John|Smith|john.smith@gmail.com|Los Angeles|1
    Jane|Roberts|janer@msn.com|San Francisco, CA|0
    Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1 "Alexandra Alex"
     */

    private String parseCSV(String s) {
        final StringBuilder sb = new StringBuilder();
        final List<String> row = new ArrayList<>();

        boolean inQuote = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (inQuote) {
                if (c == '"') {
                    if (i == s.length() - 1 || s.charAt(i + 1) != '"') inQuote = false;
                    else if (s.charAt(i + 1) == '"') sb.append(s.charAt(i++));
                } else sb.append(c);
            } else {
                if (c == '"') inQuote = true;
                else if (c == ',') {
                    row.add(sb.toString());
                    sb.setLength(0);
                } else sb.append(c);
            }
        }

        if (sb.length() > 0) row.add(sb.toString());
        return String.join("|", row);
    }
}
