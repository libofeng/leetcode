package com.leetcode.string;

public class No751IPToCIDR {
    // https://blog.csdn.net/u012737193/article/details/78945869
    // http://www.cnblogs.com/grandyang/p/8440087.html
    // https://zhuanlan.zhihu.com/p/35541808

    public String IC(String ip, int n) {
        long x = toLong(ip);
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int total = (int) (x & -x);
            while (total > n) total >>= 1;
            sb.append(toCIDR(x, total)).append(" ");
            n -= total;
            x += total;
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private long toLong(String ip) {
        String[] ips = ip.split("\\.");
        long longIp = 0;

        for (String i : ips) {
            longIp <<= 8;
            longIp += Long.parseLong(i);
        }

        return longIp;
    }

    private String toCIDR(long x, int total) {
        int n = 0;
        while (total > 1) {
            n++;
            total >>= 1;
        }
        int[] ips = new int[4];
        for (int i = 3; i >= 0; i--) {
            ips[i] = (int) (x & 255);
            x >>= 8;
        }

        return ips[0] + "." + ips[1] + "." + ips[2] + "." + ips[3] + "/" + (32 - n);
    }


    public static void main(String[] args) {
        No751IPToCIDR solution = new No751IPToCIDR();
        System.out.println(solution.IC("255.0.0.7", 10));
    }
}
