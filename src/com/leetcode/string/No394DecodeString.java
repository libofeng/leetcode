package com.leetcode.string;

public class No394DecodeString {
    private int p;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        while(p<s.length()){
            char c = s.charAt(p);

            if(Character.isDigit(c)) {
                int n = nextNum(s);
                p++;
                String str = decodeString(s);
                for(int i = 0;i<n;i++) sb.append(str);
            }else if(c == ']') {
                p++;
                return sb.toString();
            }else sb.append(s.charAt(p++));
        }

        return sb.toString();
    }

    private int nextNum(String s){
        int n = 0;
        while(p<s.length() && Character.isDigit(s.charAt(p))) n = n*10 + (s.charAt(p++) - '0');
        return n;
    }
}
