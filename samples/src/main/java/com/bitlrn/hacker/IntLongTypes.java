package com.bitlrn.hacker;

import java.util.Scanner;

public class IntLongTypes {
    public static long pow(int base, int power){
        long prod = 1;
        for (int i = 1; i <= power;++i){
            prod = base *prod;
        }
        return prod;
    }
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127){
                    System.out.println("* byte");
                }

                if (x >= -1*pow(2,15) && x <= (pow(2,15)-1)){
                    System.out.println("* short");
                }

                if (x >= -1*pow(2,31) && x <= (pow(2,31)-1)){
                    System.out.println("* int");
                }

                if (x >= -1*pow(2,63) && x <= (pow(2,63)-1)){
                    System.out.println("* long");
                }
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}
