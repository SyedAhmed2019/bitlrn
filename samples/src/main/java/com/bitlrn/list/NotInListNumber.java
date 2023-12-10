package com.bitlrn.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotInListNumber {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-1, -2, -3, 4, -5, -6);

        // sort the input list
        Collections.sort(input);
        boolean found = false;
        for (int current : input) {
            int firstNumberNotInList = current + 1;
            if (current > 0 && !input.contains(firstNumberNotInList)) {
                found = true;
                System.out.println(firstNumberNotInList);
                break;
            }
        }
        if (!found) {
            System.out.println(input.get(input.size() - 1) + 1);
        }
    }
}
