package com.leetcode.string;

public class No686RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        final StringBuilder sb = new StringBuilder();

        int count = 0;
        while(sb.length() < B.length() + 2 * A.length()){
            sb.append(A);
            count ++;
            if(sb.indexOf(B)>=0) return count;
        }

        return -1;
    }
}
