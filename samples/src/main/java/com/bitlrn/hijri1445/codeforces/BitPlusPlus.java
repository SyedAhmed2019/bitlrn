package com.bitlrn.hijri1445.codeforces;

import java.util.Scanner;

public class BitPlusPlus {

    public static void main(String[] args) {
        BitPlusPlus bpp = new BitPlusPlus();
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer result = 0;
        for (int i = 0; i < count; ++i) {
            result += bpp.execute(scanner.next(), 0);
        }
        System.out.println(result);

    }

    private Integer execute(String next, Integer sum) {
        if (next.contains("+")) {
            sum += 1;
        } else if (next.contains("-")) {
            sum -= 1;
        }
        return sum;
    }
}
