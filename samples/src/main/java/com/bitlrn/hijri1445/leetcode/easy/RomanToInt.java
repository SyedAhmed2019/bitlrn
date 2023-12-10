package com.bitlrn.hijri1445.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// given a roman number convert to int
public class RomanToInt {
    private static final Map<String,Integer> values = new HashMap<>();
    static{
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
        values.put("IV", 4);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("IX", 9);
        values.put("CD", 400);
        values.put("CM",900);
    }

    public int romanToInt(String romanNumbers) {
        if(romanNumbers == null){
            return 0;
        }
        int sum = 0;
        if (romanNumbers.length()==1){
            Integer result = values.get(""+romanNumbers.charAt(0));
            if(result != null){
                return sum+=result;
            }else{
                return 0;
            }
        }else{
            int i = 0;
            int j;
            // IVXMXD
            while (i < romanNumbers.length()){
                j = i+1;
                if (j < romanNumbers.length()) {
                    if (values.containsKey(romanNumbers.substring(i, j + 1))) {
                        sum += values.get(romanNumbers.substring(i, j + 1));
                        i += 2;
                        continue;
                    }
                }
                Integer result = values.get(""+romanNumbers.charAt(i));
                if (result!= null){
                    sum+=result;
                }
                i+=1;
            }
            return sum;
        }
    }

    public int romanToIntSol(String input){
        int i = 0;
        int sum = 0;
        while (i < input.length()){
            Integer first = values.get(input.substring(i,i+1));
            Integer second = null;
            if (i+1 < input.length()) {
                second = values.get(input.substring(i + 1, i + 2));
            }
            if ((first!=null && second != null)
                     && (first < second)){
                    sum += second-first;
                    i += 2;
            }else{
                    sum += first;
                    i+=1;
            }
        }
        return sum;
    }
    public static void main(String args[]){
        //read the string of roman number;
        Scanner scanner = new Scanner(System.in);
        //String romanNumbers = scanner.next();
        RomanToInt romanToInt = new RomanToInt();
        // special XL = 40
        // special IV = 4
        // special IX = 9
        // M
        // MD
        // MDC
        // MDCL
        //  MD  M i=0, j=1 len = 4
        //  DC  D i=1, j=2 len = 4
        //  CL  C i=2, j=3 len = 4
        //      L i=3, j=4 len = 4;

        System.out.println("Integer sum = "+romanToInt.romanToInt("M"));
        System.out.println("Integer sum = "+romanToInt.romanToInt("MD"));
        System.out.println("Integer sum = "+romanToInt.romanToInt("MDC"));
        System.out.println("Integer sum = "+romanToInt.romanToInt("MDCL"));
        System.out.println("Integer sum = "+romanToInt.romanToInt("IX"));

        System.out.println("Preferred below:");

        System.out.println("Integer sum = "+romanToInt.romanToIntSol("M"));
        System.out.println("Integer sum = "+romanToInt.romanToIntSol("MD"));
        System.out.println("Integer sum = "+romanToInt.romanToIntSol("MDC"));
        System.out.println("Integer sum = "+romanToInt.romanToIntSol("MDCL"));
        System.out.println("Integer sum = "+romanToInt.romanToIntSol ("IX"));


    }
}
