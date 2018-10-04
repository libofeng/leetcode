package com.leetcode.stack;

public class No32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0, depth = 0, start =-1, len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c=='(') depth ++;
            else{
                depth --;
                if(depth<0){
                    start = i;
                    depth = 0;
                }else if(depth ==0){
                    maxLen = Math.max(maxLen, i - start);
                }
            }
        }

        start = len;
        depth = 0;
        for(int i = len-1;i>=0;i--){
            char c = s.charAt(i);
            if(c==')') depth ++;
            else{
                depth --;
                if(depth<0){
                    depth =0;
                    start = i;
                }else if(depth == 0){
                    maxLen = Math.max(maxLen, start - i);
                }
            }
        }

        return maxLen;
    }
}
