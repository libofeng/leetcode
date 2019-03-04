package com.company.facebook;

public class ValidateEncryption {
    public boolean validate(String text, String encrypted) {
        int start = 0;
        for (int i = 0; i < encrypted.length(); ) {
            char c = encrypted.charAt(i);
            int len = 0;

            i++;
            for (; i < encrypted.length(); i++) {
                char n = encrypted.charAt(i);
                if (Character.isDigit(n)) len = len * 10 + (n - '0');
                else break;
            }

            if (len == 0) len = 1;
            if (!validate(text, start, c, len)) return false;
            start += len;
        }

        return true;
    }

    private boolean validate(String text, int start, char c, int len) {
        int count = 0;
        for (int i = start; i < text.length() && count < len; i++) {
            if (c != text.charAt(i)) return false;
            count++;
        }

        return count == len;
    }

    public static void main(String[] args) {
        ValidateEncryption solution = new ValidateEncryption();

        boolean valid = solution.validate("aaaabcc", "a4bc2");
        System.out.println("valid = " + valid);

        valid = solution.validate("abbbcccdddd", "ab3c3d4");
        System.out.println("valid = " + valid);
    }
}
