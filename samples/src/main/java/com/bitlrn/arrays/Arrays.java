package com.bitlrn.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Contains all arrays related algorithm questions.
 */


public class Arrays {

   static class ArraySummer {
        /**
         * Brute force approach to find the maximum sum of K elements in
         * an array
         *
         * @param A represents an Array of N integers N= length of array
         * @param k represents the number of elements that needs to be added
         *          to get maximum sum
         * @return max sum of k elements in an array
         */
        static int findMaxSumOfKElementsBruteForce(int A[], int k) {
            // selection sort
            for (int i = 0; i < A.length; ++i) {
                for (int j = i + 1; j < A.length; ++j) {
                    if (A[i] >= A[j]) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                    }
                }
            }
            int maxSum = 0;
            for (int j = A.length - 1; j >= A.length - k; j--) {
                maxSum += A[j];
            }
            return maxSum;
        }

       /**
        * <Note>
        * Just tries to find form either front or back of the array
        * not equal to the brute force that tries to find from entire array
        * Sliding window.
        * </Note>
        */

        static int findMaxSumOfKElementsEfficient(int[] a, int k) {
            int sum = 0;
            for( int i=0; i < k; ++i){
                sum += a[i];
            }
            int currentMax = sum;
            for(int i=k-1,j=a.length-1; i>=0 && j>=a.length-k;--i,j--){
                sum -= a[i];
                sum += a[j];
                currentMax = Math.max(currentMax, sum);
            }
            return currentMax;
        }

    }

    static class ArrayFinder {

        /**
         * Find common elements in 3 arrays
         * Brute force -- O(N^2) and space complexity O(N)
         */
        static List<Integer> findCommonElementsIn3SortedArrayBruteForce(int[] a, int[] b, int[] c) {
            // assumption all the 3 arrays are of equal length
            List<Integer> result = new ArrayList<>();
            //brute force
            int k = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        result.add(a[i]);
                    }
                }
            }

            Iterator<Integer> iterator = result.listIterator();
            while (iterator.hasNext()) {
                boolean found = false;
                int current = iterator.next();
                for (int l = 0; l < c.length; l++) {
                    if (current == c[l]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    iterator.remove();
                }
            }
            return result;
        }


        /**
         * Find common elements in 3 arrays
         * Time complexity O(N) and space complexity O(N)
         * Utilizes map to check for common elements;
         */
        static Set<Integer> findCommonElementsIn3SortedArrayEfficient(int[] a, int[] b, int[] c) {
            // assumption all the 3 arrays are of equal length
            Map<Integer,Integer> counterMap = new HashMap<>();
            // O(N)
            for (int i = 0; i < a.length; i++) {
                counterMap.putIfAbsent(a[i],1);
            }
            //O(N)
            for (int i=0; i < b.length;i++){
                counterMap.computeIfPresent(b[i],(key,val)->++val);
            }
            // O(N)
            for (int i=0; i < c.length;i++){
                counterMap.computeIfPresent(c[i],(key,val)->++val);
            }
            // O(N)
            return counterMap.entrySet().stream().filter(entry->entry.getValue()==3).collect(Collectors.toMap(entry->entry.getKey(),entry->entry.getValue())).keySet();
        }


        /**
         * Prints common elemnts between 3 sorted array
         * Most efficient have just O(N) and O(1) space complexity
         */
        static void findCommonElementsIn3SortedArrayEfficient2(int ar1[], int ar2[], int ar3[])
        {
            // Initialize starting indexes for ar1[], ar2[] and
            // ar3[]
            int i = 0, j = 0, k = 0;

            // Iterate through three arrays while all arrays
            // have elements
            while (i < ar1.length && j < ar2.length
                    && k < ar3.length) {
                // If x = y and y = z, print any of them and
                // move ahead in all arrays
                if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                    System.out.print(ar1[i] + " ");
                    i++;
                    j++;
                    k++;
                }

                // x < y
                else if (ar1[i] < ar2[j])
                    i++;

                    // y < z
                else if (ar2[j] < ar3[k])
                    j++;

                    // We reach here when x > y and z < y, i.e., z
                    // is smallest
                else
                    k++;
            }
        }

        /**
         * Returns true if any of the sub array elements sum is 0
         *
         * @param a - given array
         * @return true if any subarray with sum being 0
         */
        static boolean IsSubArraySumIsZero(int a[]){
            Map<Integer,Integer> countMapper = new HashMap<>();
            int prefixSum = a[0];
            countMapper.putIfAbsent(prefixSum,1);
            for(int i=1; i < a.length; ++i){
                prefixSum += a[i];
                if(countMapper.containsKey(prefixSum)){
                    return true;
                }else{
                    countMapper.putIfAbsent(prefixSum,1);
                }
            }
            return false;
        }

        static boolean IsSubArraySumIsZero2(int a[]){
            // Creates an empty hashset hs
            Set<Integer> hs = new HashSet<Integer>();

            // Initialize sum of elements
            int sum = 0;

            // Traverse through the given array
            for (int i = 0; i < a.length; i++)
            {
                // Add current element to sum
                sum += a[i];

                // Return true in following cases
                // a) Current element is 0
                // b) sum of elements from 0 to i is 0
                // c) sum is already present in hash set
                if (a[i] == 0
                        || sum == 0
                        || hs.contains(sum))
                    return true;

                // Add sum to hash set
                hs.add(sum);
            }

            // We reach here only when there is
            // no subarray with 0 sum
            return false;
        }
    }

    public static void main(String[] args) {

        //1. Find max sum of K elements from front or back of array
        int a[] = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35 };
        System.out.println(ArraySummer.findMaxSumOfKElementsBruteForce(a,48));
        System.out.println(ArraySummer.findMaxSumOfKElementsEfficient(a,48));

        System.out.println("Finding common elements in an array");
        List<Integer> result = ArrayFinder.findCommonElementsIn3SortedArrayBruteForce(new int[]{1,2,3,4,5},new int[]{4,5,6,7,0},new int[]{4,5,6,7,9});
        result.stream().forEach(System.out::println);
        Set<Integer> resultSet = ArrayFinder.findCommonElementsIn3SortedArrayEfficient(new int[]{1,2,3,4,5},new int[]{4,5,6,7,0},new int[]{4,5,6,7,9});
        resultSet.stream().forEach(System.out::println);
        ArrayFinder.findCommonElementsIn3SortedArrayEfficient2(new int[]{1,2,3,4,5},new int[]{4,5,6,7,0},new int[]{4,5,6,7,9});
        System.out.println("Subarray sum is zero?");
        System.out.print(ArrayFinder.IsSubArraySumIsZero(new int[]{1,2,-5,5,3}));
        System.out.println(ArrayFinder.IsSubArraySumIsZero2(new int[]{1,2,-5,5,3}));
    }
}
