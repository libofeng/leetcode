package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class No843GuessTheWord {
    // https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
    public void findSecretWord(String[] wordlist, Master master) {
        final Random rnd = new Random();
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[rnd.nextInt(wordlist.length)];
            x = master.guess(guess);

            final List<String> list = new ArrayList<>();
            for (String w : wordlist) if (match(guess, w) >= x) list.add(w);
            wordlist = list.toArray(new String[list.size()]);
        }
    }

    private int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) == b.charAt(i)) count++;
        return count;
    }

    interface Master {
        public int guess(String word);
    }
}
