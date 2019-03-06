package com.leetcode.string;

public class No468ValidateIpAddress {
    public String validIPAddress(String IP) {
        final String INVALID = "Neither", IPv4 = "IPv4", IPv6 = "IPv6";
        if (IP == null || IP.isEmpty()) return INVALID;

        int dotIndex = IP.indexOf("."), colonIndex = IP.indexOf(":");
        if ((dotIndex > 0 && colonIndex > 0) || (dotIndex <= 0 && colonIndex <= 0)) return INVALID;

        if (dotIndex > 0) {
            if (IP.endsWith(".")) return INVALID;
            String[] sections = IP.split("\\.");
            if (sections.length != 4) return INVALID;
            for (String section : sections) {
                if (section.isEmpty() || section.length() > 3
                        || (section.length() > 1 && section.startsWith("0"))) return INVALID;

                int n = 0;
                for (int i = 0; i < section.length(); i++) {
                    char c = section.charAt(i);
                    if (!Character.isDigit(c)) return INVALID;
                    n = n * 10 + (c - '0');
                }

                if (n > 255) return INVALID;
            }

            return IPv4;
        } else {
            if (IP.endsWith(":")) return INVALID;
            String[] sections = IP.split(":");
            if (sections.length != 8) return INVALID;
            for (String section : sections) {
                if (section.isEmpty() || section.length() > 4) return INVALID;
                for (int i = 0; i < section.length(); i++) {
                    char c = section.charAt(i);
                    if (!Character.isLetterOrDigit(c)) return INVALID;
                    if (Character.isLetter(c) && Character.toLowerCase(c) > 'f') return INVALID;
                }
            }
        }

        return IPv6;
    }
}
