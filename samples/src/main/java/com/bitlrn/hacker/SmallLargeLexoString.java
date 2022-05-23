package com.bitlrn.hacker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallLargeLexoString {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        List<String> results = new ArrayList<>(s.length());
        for (int i = 0; i < s.length() - k + 1; ++i) {
            results.add(s.substring(i, i + k));
        }
        //here we will find the smallest and largest
        smallest = results.get(0);
        largest = results.get(0);

        for (String current : results) {
            if (smallest.compareTo(current) > 0) {
                smallest = current;
            }
            if (largest.compareTo(current) < 0) {
                largest = current;
            }
        }


        return smallest + "\n" + largest;
    }

    public static String getSmallestAndLargest2(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        String[] results = new String[k * s.length()];
        for (int i = 0; i < s.length() - k + 1; ++i) {
            results[i] = s.substring(i, i + k);
        }
        //here we will find the smallest and largest
        smallest = results[0];
        largest = results[0];

        for (String current : results) {
            if (current != null) {
                if (smallest.compareTo(current) > 0) {
                    smallest = current;
                }
                if (largest.compareTo(current) < 0) {
                    largest = current;
                }
            }
        }


        return smallest + "\n" + largest;
    }

    public static String getSmallestAndLargest3(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        for (int i = 1; i < s.length() - k + 1; ++i) {
            String current = s.substring(i, i + k);
            if (current.compareTo(smallest) > 0) {
                smallest = current;
            }
            if (largest.compareTo(current) < 0) {
                largest = current;
            }
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest2(s, k));
    }
}
