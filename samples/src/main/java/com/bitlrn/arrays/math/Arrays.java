package com.bitlrn.arrays.math;

import com.bitlrn.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This contains all algorithm problems wherein some mathematical
 * aspect of array elements is asked
 * e.g. the sum of two elements adds upto 'N' etc.
 */
public class Arrays {
    /*
    Given an array and a number "n", find two numbers from the array
    that sums up to "n".
    1,2,3,4,5,7  and n=6
    1 2,3,4,5,7
    */
    int[] findSum(int a[],int n){
        Map<Integer,Integer> complementHolder = new HashMap<>();
        for (int i=0; i < a.length;++i){
            if (complementHolder.containsKey(a[i])){
                return new int[]{a[complementHolder.get(a[i])],a[i]};
            }else{
                complementHolder.put(n-a[i],i);
            }
        }
        return new int[2];
    }

    /*
    Given an array and a number "n", find two number indices from the array
    that sums up to "n".
    1,2,3,4,5,7  and n=6
    1 2,3,4,5,7
    */
    int[] findSumIndices(int a[],int n){
        Map<Integer,Integer> complementHolder = new HashMap<>();
        for (int i=0; i < a.length;++i){
            if (complementHolder.containsKey(a[i])){
                return new int[]{complementHolder.get(a[i]),i};
            }else{
                complementHolder.put(n-a[i],i);
            }
        }
        return new int[2];
    }

    /**
     * find array of products all elements except itself
     * using division
     * @param a - input array
     * @return an array of products all elements except itself
     */
    int[] findProductExceptItself(int a[]){
        int currentProduct = 1;
        int zeroCount = 0;
        for (int i =0; i < a.length; i++){
            if (a[i]!=0) {
                currentProduct *= a[i];
            }else{
                zeroCount++;
            }
        }
        for (int i=0; i < a.length;i++){
            if(a[i] != 0) {
                if (zeroCount>0) {
                    a[i] = 0 ;
                }else{
                   a[i] = currentProduct / a[i];
                }
            }else{
                if (zeroCount>1) {
                    a[i] = 0;
                }else{
                    a[i] = currentProduct;
                }
            }
        }
        return a;
    }

    /**
     * Find the product without itself without using
     * division
     * Strategy:
     * Find the left-hand side product and save it in a result array
     * multiply the left-hand side product in result array
     * with right-hand side product
     * @param a
     * @return
     */
    public static int[] findProductWithoutDivision(int a[])
    {
        int n = a.length;
        int temp = 1;


        int result[] = new int[n];

        // Product of elements on left-side
        for (int i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= a[i];
        }

        temp = 1;

        // Product of elements on right-side
        for (int i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= a[i];
        }

        return result;
    }

    /**
     * Given an array as input find minimum value in the array
     * @param a
     * @return min value
     */
    int findMinimum(int a[]){
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<a.length;++i){
            if (a[i]<minValue){
                minValue = a[i];
            }
        }
        return minValue;
    }

    public int findFirstNonRepeatingNumber(int[] input) {
       Map<Integer,Integer> nonRepeating = new LinkedHashMap<>();
        for (int i=0; i <input.length;++i){
            if(!nonRepeating.containsKey(input[i])){
                nonRepeating.put(input[i],1);
            }else{
                nonRepeating.put(input[i],nonRepeating.get(input[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:nonRepeating.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Second max value in the array
     * @param input
     * @return second max value of array
     */
    public int findSecondLargestElement(int[] input) {
        int max = 0;
        int secondMax = 0;
        for(int i=0; i < input.length;++i){
            if (input[i] >= max){
                secondMax = max;
                max = input[i];
            }else if (input[i] > secondMax){
                secondMax = input[i];
            }
        }
        return secondMax;
    }

    /**
     * Given an array, can you rotate its elements once from right to left
     * by one index ?
     * @param a - input array
     * @return rotated array by 1 index.
     *
     * 1 2 3 4 5
     * 1 2 3 4 4
     * 1 2 3 3 4
     * 1 2 2 3 4
     * 1 1 2 3 4
     *
     */
    public void rotateAnArrayByOneIndex(int[] a) {
        int right = a[a.length-1];
        for(int i=a.length-1; i>0;i--) {
            a[i] = a[i-1];
        }
        a[0] = right;
    }

    /**
     * Given an array, rearrange so that negative numbers
     * are at beginning and positive ones are at end
     * @param a
     * @return updated array
     *
     * e.g.
     * 1 2 3 -4 5 6 -7  --> -4,-7,1,2,3,5,6
     *  -7 2 3 -4 5 6 1
     *  -7 -4 3 2 5 6 1
     *-1 2 -3 4 -5 6 -7
     * -1 -7 -3 4 -5 6 2
     *
     * 1 0 1 0 2 1
     *
     */
    public void rearrangeNegativePositiveNumbers(int[] a) {
        int low = 0;
        int high = a.length -1;
        while(low < high){
            if (a[low] > 0){
                if (a[high]<0) {
                    int temp = a[low];
                    a[low] = a[high];
                    a[high] = temp;
                    low++;
                }
                high--;
            }else{
                low++;
            }
        }
    }

    /**
     * Arrange sorted array in Max-Min form
     * @param a
     *
     * -1,0,2,3,4,5
     * 1 2 3 4 5 6
     * 6 2 3 4 5 1
     * 6 2 5 4 3 1
     * 6 1 5 4 3 2
     * 6 1 5 2 3 4
     * 6 1 5 2 4 3
     *
     * 1 2 3 4 5 6 7
     * 7 2 6 4 5 3 1
     * 7 1 6 4 5 3 2
     * 7 1 6 2 5 3 4
     * 7 1 6 2 5
     */
    public void rearrangeMaxMinForm(int[] a) {
        int high = a.length-1;
        int low = 0;
        // first round place the max ones in position
        while (low < high){
            int temp = a[low];
           a[low] = a[high];
           a[high] = temp;
           high--;
           low+=2;
        }
        // second round we keep on swapping odd index with high
        low=1;
        high=a.length-1;
        while (low < high){
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low+=2;
        }
        high= a.length-1;
        low = a.length-2;
        if (a[low]>a[high]) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }
    }


    /*
      Basically 1,2,3,4,5
     */
    public void rearrangeMaxMinFormEfficient(int[] a) {
        java.util.Arrays.sort(a);
        int maxIndex = a.length-1;
        int minIndex = 0;
        int maxNumber = a[maxIndex] +1;
        for(int i=0; i < a.length;++i) {
            if (i % 2 == 0) {
                a[i] += (a[maxIndex] % maxNumber) * maxNumber;
                maxIndex--;
            } else {
                a[i] += (a[minIndex] % maxNumber) * maxNumber;
                minIndex++;
            }
        }
        for( int i = 0; i < a.length; i++) {
            a[i] = a[i] / maxNumber;
        }

    }

   public ArrayList<Integer> subarraySum(int[] a, int n, int s)
    {
        ArrayList<Integer> result  = new ArrayList<>();
        int currentSum = 0;
        int low = 0;
        while (low < n){
            for (int i=low;i<n;i++ ){
                if (currentSum+a[i] < s){
                    result.add(i);
                    currentSum += a[i];
                    low++;
                }else if (currentSum+a[i] == s){
                    result.add(i);
                    ArrayList<Integer> newResult = new ArrayList<>();
                    newResult.add(result.get(0)+1);
                    if (result.size()>1){
                        newResult.add(result.get(result.size()-1)+1);
                    }
                    return newResult;
                }else{
                    currentSum -= a[result.remove(0)];
                    break;
                }
            }
        }

        return result;
    }
}
