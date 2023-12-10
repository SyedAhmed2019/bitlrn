package com.bitlrn.dgio.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array check if it contains duplicates
 * return true if it contains else false
 */
public class DuplicatesChecker {
    public static void main(String[] args) {
        DuplicatesChecker dc = new DuplicatesChecker();
        print(dc.containsDuplicate(new int[]{1, 1, 0, 2, 2}));
        print(dc.containsDuplicate(new int[]{-1, 1, 0}));
        print(dc.containsDuplicate(new int[]{1, 2, 3, 4}));
        print(dc.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    private static void print(boolean result) {
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            uniqueSet.add(nums[i]);
        }
        return !(uniqueSet.size() == nums.length);
    }
}
