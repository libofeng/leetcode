package com.company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int calculate(String s) {
        List<Integer> numbers = parseNumbers(s);
        List<Character> operations = parseOperators(s);

        int result = numbers.get(0), last = result, index = 0;
        for (int i = 1; i < numbers.size(); i++) {
            int num = numbers.get(i);

            switch (operations.get(index++)) {
                case '+':
                    last = num;
                    result += last;
                    break;
                case '-':
                    last = -num;
                    result += last;
                    break;
                case '*':
                    result -= last;
                    last = last * num;
                    result += last;
                    break;
                case '/':
                    result -= last;
                    last = last / num;
                    result += last;
                    break;
                default:
            }
        }
        return result;
    }

    private List<Character> parseOperators(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') list.add(c);
        }

        return list;
    }

    private List<Integer> parseNumbers(String s) {
        List<Integer> list = new ArrayList<>();
        String[] nums = s.split("[*+-/]");
        for (String n : nums) list.add(Integer.parseInt(n.trim()));
        return list;
    }

    public static void main(String[] args) {
        Calculator solution = new Calculator();
        int result = solution.calculate("3 + 4*5*9 + 5+7*6*19");
        System.out.println("result = " + result);
    }
}
