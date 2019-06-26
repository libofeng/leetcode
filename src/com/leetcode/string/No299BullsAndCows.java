package com.leetcode.string;

public class No299BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) if (secret.charAt(i) == guess.charAt(i)) bulls++;

        final int[] counter = new int[128];
        for (char c : secret.toCharArray()) counter[c]++;

        int cows = 0;
        for (char c : guess.toCharArray()) if (counter[c]-- > 0) cows++;

        cows -= bulls;

        return bulls + "A" + cows + "B";
    }

    public String getHint2(String secret, String guess) {
        int bulls = 0, cows = 0;

        final int[] counter = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
            if (s == g) bulls++;
            else {
                if (counter[s]++ < 0) cows++;
                if (counter[g]-- > 0) cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
