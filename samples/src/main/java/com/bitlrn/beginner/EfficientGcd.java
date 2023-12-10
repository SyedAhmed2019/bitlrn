package com.bitlrn.beginner;

public class EfficientGcd {
    /**
     * The following computes GCD of two numbers using
     * the Euclid GCD calculation method that works efficiently
     * even if the two numbers are very large
     */
    public static int computeGcd(final int a, final int b) {
        if (b==0){
            return a;
        }
        int rem = a%b;
        return computeGcd(b,rem);
    }

    public static void main(String[] args) {
        int a = 16;
        int b = 64;
        System.out.println(EfficientGcd.computeGcd(64,16));
        System.out.println(EfficientGcd.computeGcd(3918848,1653264));
    }
}
