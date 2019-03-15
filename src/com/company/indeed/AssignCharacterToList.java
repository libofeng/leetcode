package com.company.indeed;

import java.util.ArrayList;
import java.util.List;

public class AssignCharacterToList {
    public List<List<Character>> assignCharacters(char[] chars) {
        final List<List<Character>> result = new ArrayList<>();
        if (chars.length == 0) return result;

        result.add(new ArrayList<>());
        for (char c : chars) {
            List<Character> targetList = null;
            for (List<Character> list : result) {
                if (list.contains(c)) continue;
                targetList = list;
                break;
            }

            if (targetList == null) {
                targetList = new ArrayList<>();
                result.add(targetList);
            }
            targetList.add(c);
        }

        return result;
    }

    public List<List<Character>> assignCharacters2(char[] chars) {
        final List<List<Character>> result = new ArrayList<>();
        final int[] counter = new int[26];
        int maxCount = 0;
        for (char c : chars) maxCount = Math.max(maxCount, ++counter[c - 'a']);
        for (int i = 0; i < maxCount; i++) result.add(new ArrayList<>());

        final int[] index = new int[26];
        for (char c : chars) result.get(index[c - 'a']++).add(c);

        return result;
    }

    public static void main(String[] args) {
        AssignCharacterToList solution = new AssignCharacterToList();
        List<List<Character>> result = solution.assignCharacters("abcaab".toCharArray());
        System.out.println("result1 = " + result);
        result = solution.assignCharacters2("abcaab".toCharArray());
        System.out.println("result2 = " + result);

        result = solution.assignCharacters("aaabbb".toCharArray());
        System.out.println("result1 = " + result);
        result = solution.assignCharacters2("aaabbb".toCharArray());
        System.out.println("result2 = " + result);
    }
}
