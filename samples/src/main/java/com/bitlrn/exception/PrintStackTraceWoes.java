package com.bitlrn.exception;

public class PrintStackTraceWoes {
    public static void main(String[] args) {
        try{
            System.out.println("creating a divide zero scenario");
            int result = 10/0;
        }catch(Exception e){
            e.printStackTrace();
        }

        for (int i=0; i < 10; ++i){
            System.out.println("continue "+i);
        }
    }
}
