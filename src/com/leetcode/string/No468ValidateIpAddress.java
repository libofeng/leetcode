package com.leetcode.string;

public class No468ValidateIpAddress {
    public String validIPAddress(String IP) {
        final String INVALID = "Neither", IPv4 = "IPv4", IPv6 = "IPv6";
        if (IP == null || IP.isEmpty()) return INVALID;

        if (IP.indexOf(".") > 0 && isValidIPv4(IP)) return IPv4;
        if (IP.indexOf(":") > 0 && isValidIPv6(IP)) return IPv6;

        return INVALID;
    }

    private boolean isValidIPv4(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".")) return false;

        String[] sections = IP.split("\\.");
        if (sections.length != 4) return false;
        for (String section : sections) {
            if (section.isEmpty() || section.length() > 3
                    || (section.length() > 1 && section.startsWith("0"))) return false;

            int n = 0;
            for (int i = 0; i < section.length(); i++) {
                char c = section.charAt(i);
                if (!Character.isDigit(c)) return false;
                n = n * 10 + (c - '0');
            }

            if (n > 255) return false;
        }

        return true;
    }

    private boolean isValidIPv6(String IP) {
        if (IP.startsWith(":") || IP.endsWith(":")) return false;

        String[] sections = IP.split(":");
        if (sections.length != 8) return false;

        for (String section : sections) {
            if (section.isEmpty() || section.length() > 4) return false;
            for (int i = 0; i < section.length(); i++) {
                char c = section.charAt(i);
                if (!Character.isLetterOrDigit(c)) return false;
                if (Character.isLetter(c) && Character.toLowerCase(c) > 'f') return false;
            }
        }

        return true;
    }
}
