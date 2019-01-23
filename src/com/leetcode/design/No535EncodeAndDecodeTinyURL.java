package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class No535EncodeAndDecodeTinyURL {

    private final static Map<String, String> DB = new HashMap<>();
    private final static String HOST = "http://www.tinyurl.com/";
    private final static String DICT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static int BASE = 62;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrl == null) return null;

        long hashcode = 2 * ((long) Integer.MAX_VALUE) + longUrl.hashCode();
        String key = toBase62(hashcode);
        DB.put(key, longUrl);

        return HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null || !shortUrl.startsWith(HOST)) return shortUrl;

        return DB.get(shortUrl.substring(HOST.length()));
    }


    private String toBase62(long n) {
        StringBuilder sb = new StringBuilder();
        while (n >= BASE) {
            sb.append(DICT.charAt((int) (n % BASE)));
            n /= BASE;
        }
        sb.append(DICT.charAt((int) (n % BASE)));

        return sb.toString();
    }

    public static void main(String[] args) {
        No535EncodeAndDecodeTinyURL solution = new No535EncodeAndDecodeTinyURL();
        String shortUrl = solution.encode("http://www.google.com/abcdefg");
        System.out.println("shortUrl = " + shortUrl);
        System.out.println("longUrl = " + solution.decode(shortUrl));

        shortUrl = solution.encode("http://www.facebook.com/abcdefg");
        System.out.println("shortUrl = " + shortUrl);
        System.out.println("longUrl = " + solution.decode(shortUrl));

        shortUrl = solution.encode("http://www.linkedin.com/abcdefg");
        System.out.println("shortUrl = " + shortUrl);
        System.out.println("longUrl = " + solution.decode(shortUrl));

    }
}
