package com.company.indeed;

import java.util.*;

/*


if order matters, longest common sub-sequence
 */
public class NormalizeTitle {

    public String getHighestMatch(String raw, String[] cleanTitles) {
        Set<String> rawSet = new HashSet<>(Arrays.asList(raw.split(" ")));

        int max = 0;
        String res = null;
        for (String each : cleanTitles) {
            int cur = helper(rawSet, each);
            if (cur > max) {
                max = cur;
                res = each;
            }
        }

        return max == 0 ? cleanTitles[0] : res;
    }

    private int helper(Set<String> raw, String cleanTitle) {
        int count = 0;
        for (String each : cleanTitle.split(" ")) {
            if (raw.contains(each))
                count++;
        }
        return count;
    }

}
