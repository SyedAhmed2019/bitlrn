package com.bitlrn.hijri1445.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryDigits {

    private Map<Integer,Integer> history = new HashMap<>();
    // given a number N, create an array n+1 size,
    // where each index holds the binary digits number 1 length of index
    public int findBinary1Len(int input){
        int numOfOnes = 0;
        int rem, quot;
        quot = input;
        int numberOfTimesInLoop = 0;
        do{
           // System.out.println("In loop for "+ (++numberOfTimesInLoop) + " times for
            // input:"+input);
           rem = quot%2;
           if (quot==1 || rem == 1){
               ++numOfOnes;
           }

            if(history.containsKey(quot/2)){
                numOfOnes +=history.get(quot/2);
                break;
            }

        }while((quot=quot/2) != 0);
        history.put(input,numOfOnes);
        return numOfOnes;
    }


    // given a number N, create an array n+1 size,
    // where each index holds the binary digits number 1 length of index
    public int findBinary1Len2(int input){
        int numOfOnes = 0;
        int rem, quot;
        quot = input;
        int numberOfTimesInLoop = 0;
        do{
           // System.out.println("In loop for "+ (++numberOfTimesInLoop) + " times for
            // input:"+input);
            rem = quot%2;
            if (quot==1 || rem == 1){
                ++numOfOnes;
            }
        }while((quot=quot/2) != 0);

        return numOfOnes;
    }

    //optimal solution
    public int[] findBinary1Len3(int input){
        int result[] = new int[input+1];
        result[0] = 0;
        for (int i = 1; i < result.length;++i){
            result[i] =  result[i/2] + i%2;
        }
        return result;

    }

    public static void main (String args[]){
        BinaryDigits as = new BinaryDigits();
        Scanner scanner = new Scanner(System.in);
        long initialTime = System.currentTimeMillis();
        System.out.println("Enter the number :");
        int number = scanner.nextInt();
        int result[] = new int[number+1];
        /*for (int i=0; i < result.length; ++i){
            result[i] = as.findBinary1Len3(i);
        }*/
        result = as.findBinary1Len3(number);
        long finalTime = System.currentTimeMillis();
        System.out.println("Total time taken:"+ (finalTime-initialTime));
        /*for (int i=0; i < result.length; ++i) {
            System.out.println(result[i]);
        }*/


    }
}
