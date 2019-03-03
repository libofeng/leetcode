package com.leetcode.contest.contest126;

public class No1003CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        if(S == null || S.length()<3) return false;
        if("abc".equals(S)) return true;

        int index = S.indexOf("abc");
        if(index<0) return false;

        return isValid(S.substring(0, index) + S.substring(index+3));
    }
}
