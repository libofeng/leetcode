package com.leetcode.string;

public class No58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;

        int right = s.length() - 1;
        while (right > 0 && s.charAt(right) == ' ') right--;

        int left = right;
        while (left > 0 && s.charAt(left) != ' ') left--;

        return right - left + (s.charAt(left) == ' ' ? 0 : 1);
    }

    public int lengthOfLastWord2(String s) {
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) if (words[i].length() > 0) return words[i].length();

        return 0;
    }
}
