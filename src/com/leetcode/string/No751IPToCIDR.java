package com.leetcode.string;

public class No751IPToCIDR {
    // https://blog.csdn.net/u012737193/article/details/78945869
    // http://www.cnblogs.com/grandyang/p/8440087.html
    // https://zhuanlan.zhihu.com/p/35541808

    public String IC(String ip, int n) {
        //思路，找到这些IPs中从右往左第一位相同的二进制位
        // x & -x ;-x是x的补码，返回x与2^64的最大公约数，
        //即x最多能被n个2整除就返回2^n,如果x是奇数返回1;返回值为0 ，说明x=0;为其他数，表示x为x与2^64的最大公约数
        //一言以蔽之就是获取32位二进制表示中从右往左首次出现1的位置
        long x = 0;
        //以"."划分每个IP
        String[] ipsegment = ip.split("\\.");
        for (int i = 0; i < ipsegment.length; i++) {
            x = Integer.parseInt(ipsegment[i]) + x * 256;
        }
        String res = "";
        while (n > 0) {
            long temp = x & -x;//求得该IP用32位二进制表示中从右往左首次出现1的位置
            //-x才是x的补码，~x为反码
            //temp如果为奇数，则该IP为第一个CIDR块
            //如果偶数，则该IP用二进制表示下的最低有效位的位数能表示的地址的数量
            while (temp > n) {
                temp = temp / 2;
            }
            //到这里temp肯定是小于n的，这告诉我们包括此IP在内的temp个IPs可以用一个ICDR来表示
            //接下来求出这些IPs所处的CIDR
            res += longToIP(x, (int) temp) + "  ";
            //x加上temp;
            x += temp;//temp个ips考虑好了，接下来考虑从x+temp考虑
            n -= temp;//还有几个IPs要求ICDR的
        }
        return res;
    }

    public String longToIP(long x, int temp) {
        int netID = 32;
        while (temp > 0) {
            temp /= 2;
            netID--;
        }

        int[] ans = new int[4];
        for (int i = 0; i < ans.length - 1; i++) {
            ans[i] = (int) (x & 255);
            x >>= 8;
        }
        ans[ans.length - 1] = (int) x;
        netID++; //加1：比如说某些IPs有m位相同，是指0-m-1位相同
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + netID;
    }


    public static void main(String[] args) {
        No751IPToCIDR solution = new No751IPToCIDR();
        System.out.println(solution.IC("255.0.0.7", 10));
    }
}
