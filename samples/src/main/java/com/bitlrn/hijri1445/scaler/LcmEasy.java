package com.bitlrn.hijri1445.scaler;

import java.util.Scanner;

// find Lcm of two number A and B
// LCM is defined as the least number that both the numbers can divide;
public class LcmEasy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int lcm = 1;
        for (int i = 2; i <= 9; ) {
            while (first % i == 0 && second % i == 0) {
                lcm *= i;
                first = first / i;
                second = second / i;
            }
            i++;
        }

        System.out.println(lcm * first * second);
    }
}
