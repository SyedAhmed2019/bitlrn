package com.bitlrn.hijri1445.leetcode.easy;

public class BinaryOnesCounter {

    // 0000 - 2
    // 0001
    // 0010
    // 0011
    // 0100
    // 0101
    // 0110
    // 0111

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int x = 1; x <= num; ++x) {
            ans[x] = ans[x & (x - 1)] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryOnesCounter boc = new BinaryOnesCounter();
        System.out.println(boc.countBits(5));
    }
}
