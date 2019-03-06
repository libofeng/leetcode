package com.leetcode.string;

public class No165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length(), i = 0, j = 0;
        while (i < m || j < n) {
            int num1 = 0, num2 = 0;
            while (i < m && Character.isDigit(version1.charAt(i))) num1 = num1 * 10 + (version1.charAt(i++) - '0');
            i++;

            while (j < n && Character.isDigit(version2.charAt(j))) num2 = num2 * 10 + (version2.charAt(j++) - '0');
            j++;

            if (num1 != num2) return num1 - num2 < 0 ? -1 : 1;
        }

        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        final String[] revisions1 = version1.split("\\.");
        final String[] revisions2 = version2.split("\\.");

        for (int i = 0; i < revisions1.length || i < revisions2.length; i++) {
            String revision1 = i < revisions1.length ? revisions1[i] : "0";
            String revision2 = i < revisions2.length ? revisions2[i] : "0";
            int result = compare(revision1, revision2);
            if (result != 0) return result;
        }

        return 0;
    }

    private int compare(String revision1, String revision2) {
        int v1 = Integer.parseInt(revision1), v2 = Integer.parseInt(revision2);
        if (v1 == v2) return 0;
        return v1 < v2 ? -1 : 1;
    }

    // to handle big number(first skip the leading zeros;
    private int compare2(String revision1, String revision2) {
        int i = 0, j = 0;
        while (i < revision1.length() && revision1.charAt(i) == '0') i++;
        while (j < revision2.length() && revision2.charAt(j) == '0') j++;

        if (revision1.length() - i != revision2.length() - j) {
            return revision1.length() - i < revision2.length() - j ? -1 : 1;
        }

        while (i < revision1.length() && j < revision2.length()) {
            char c1 = revision1.charAt(i++), c2 = revision2.charAt(j++);
            if (c1 != c2) return c1 < c2 ? -1 : 1;
        }

        return 0;
    }
}
