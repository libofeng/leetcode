package com.leetcode.string;

public class No418SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int times = 0, index = 0;
        for (int i = 0; i < rows; i++) {
            int len = 0;
            while (len + sentence[index].length() <= cols) {
                len += 1 + sentence[index++].length();
                if (index >= sentence.length) {
                    times++;
                    index = 0;
                }
            }
        }

        return times;
    }

    // https://leetcode.com/problems/sentence-screen-fitting/discuss/90846/JAVA-optimized-solution-17ms
    public int wordsTyping2(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int curLen = 0;
            int cur = i;
            int time = 0;
            while (curLen + sentence[cur].length() <= cols) {
                curLen += sentence[cur++].length() + 1;
                if (cur == sentence.length) {
                    cur = 0;
                    time++;
                }
            }
            nextIndex[i] = cur;
            times[i] = time;
        }
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            ans += times[cur];
            cur = nextIndex[cur];
        }
        return ans;
    }
}
