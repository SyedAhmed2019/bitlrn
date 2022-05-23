package com.bitlrn.hacker;

import java.util.Scanner;

public class Loop {
    public static int pow(int base, int power){
        int prod = 1;
        for (int i = 1; i <= power;++i){
            prod = base *prod;
        }
        return prod;
    }

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int prev=a;
            for ( int j=0; j<n;++j){
                System.out.println("a=" + a + " pre="+prev + " j ="+j + "b ="+ b + " 2^j="+ (2^j) + "2^j*b="+ (2^j)*b);
                prev += pow(2,j)*b;
                System.out.print(prev);
                System.out.print(" ");
            }
            System.out.println("");
        }
        in.close();
    }
}
