package com.bitlrn.dgio.arrays;


import java.util.*;

/*
  Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
public class TripletSumChecker {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Map<Integer, List<Integer>> partialSum = new HashMap<>();
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        if (arr.length == 3) {
            if (arr[0] + arr[1] + arr[2] == 0) {
                List<Integer> result = new ArrayList<>();
                result.add(arr[0]);
                result.add(arr[1]);
                result.add(arr[2]);
                triplets.add(result);
                return triplets;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            if (partialSum.containsKey(arr[i])) {
                List<Integer> alreadyTrack = partialSum.get(arr[i]);
                alreadyTrack.add(arr[i]);
                triplets.add(alreadyTrack);
                //partialSum.put(arr[i],new ArrayList<>());
            } else {
                for (int j = 0; j < arr.length; j++) {
                    if (j > 0 && arr[j - 1] == arr[j] || arr[i] == arr[j] || i == j) {
                        continue;
                    }
                    List<Integer> indicesTracker = new ArrayList<>();
                    indicesTracker.add(arr[i]);
                    indicesTracker.add(arr[j]);
                    partialSum.put(-(arr[i] + arr[j]), indicesTracker);
                }
            }

        }
        return triplets;
    }

    public static void main(String[] args) {
        TripletSumChecker tsc = new TripletSumChecker();
        List<List<Integer>> result = searchTriplets(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> input : result) {
            System.out.println(input.toString());
        }
        System.out.println(" ");
       /* result = tsc.searchTriplets(new int[]{-5, 2, -1, -2, 3});
        for(List<Integer>input:result){
            System.out.println(input.toString());
        }*/

    }

    // -3, 0, 1, 2, -1, 1, -2
    // -3, -2, -1, 0, 1,1,2
    // -3,-2,-1 = -6
    // -3 -1 0  = -4
    // -3 0, 1 = -2
    // -3 1, 1 = -1
    // -3 1,2 = 0;
    //  0, -3,1 = -2
    //
    public List<List<Integer>> searchTripletsPartial(int[] arr) {
        Map<Integer, List<Integer>> partialSum = new HashMap<>();
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] == arr[j]) {
                    break;
                }
                if (partialSum.containsKey(arr[j])) {
                    List<Integer> alreadyTrack = partialSum.remove(arr[j]);
                    alreadyTrack.add(arr[j]);
                    triplets.add(alreadyTrack);
                } else {
                    List<Integer> indicesTracker = new ArrayList<>();
                    indicesTracker.add(arr[i]);
                    indicesTracker.add(arr[j]);

                    partialSum.put(-(arr[i] + arr[j]), indicesTracker);
                }

            }
        }
        return triplets;
    }
}
