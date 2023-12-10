package com.bitlrn.hijri1445.scaler;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum fSum = new FourSum();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> input = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            input.add(scanner.nextInt());
        }
        int target = scanner.nextInt();
        ArrayList<ArrayList<Integer>> result = fSum.fourSum(input, target);
        for (ArrayList<Integer> current : result) {
            System.out.println(current);
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        //1 0 -1 0 -2 2
        //-2 -1 0 0 1 2
        //
        Integer[] input = A.toArray(new Integer[0]);
        Map<Integer, ArrayList<Integer>> cache = new HashMap<>();
        // sort
        Arrays.sort(input);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i += 1) {
            for (int j = i + 1; j < input.length; j++) {
                ArrayList<Integer> current = new ArrayList<>();
                if (cache.containsKey(input[i] + input[j])) {
                    ArrayList<Integer> found = cache.get(input[i] + input[j]);
                    if (found.size() != 4) {
                        found.add(input[i]);
                        found.add(input[j]);
                        result.add(found);
                    } else {
                        ArrayList<Integer> newFound = new ArrayList<>(4);
                        newFound.add(found.get(0));
                        newFound.add(found.get(1));
                        newFound.add(input[i]);
                        newFound.add(input[j]);
                        result.add(newFound);
                    }
                } else {
                    current.add(input[i]);
                    current.add(input[j]);
                    cache.putIfAbsent(B - (input[i] + input[j]), current);
                }
            }
        }
        return result;
    }
}
