package com.leetcode.contest.contest144;

public class No1108DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        final StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) sb.append(c == '.' ? "[.]" : c);
        return sb.toString();
    }
}
