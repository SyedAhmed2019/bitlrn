package com.bitlrn.dgio.queue;


import java.util.LinkedList;
import java.util.Queue;

public class MaxSumSubArrayCalculator {
    int[] indices;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Queue<Integer> indicesTracker = new LinkedList<>();

    public static void main(String[] args) {
        MaxSumSubArrayCalculator msac = new MaxSumSubArrayCalculator();
        System.out.println(msac.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
    }

    /**
     * The following employs queue as we wanted to track the
     * indices that is leading to the sum. The Refined version is below.
     *
     * @param k
     * @param arr
     * @return
     */
    public int findMaxSumSubArrayInitial(int k, int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        indices = new int[k];
        int kCounter = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            currentSum += arr[i];
            queue.add(arr[i]);
            indicesTracker.add(i);
            kCounter++;
            if (kCounter == k) {
                if (currentSum > maxValue) {
                    maxValue = currentSum;
                    currentSum -= queue.poll();
                    int j = 0;
                    while (!indicesTracker.isEmpty()) {
                        indices[j++] = indicesTracker.poll();
                    }
                    for (int l = 1; l < k; ++l) {
                        indicesTracker.add(indices[l]);
                    }
                } else {
                    currentSum -= queue.poll();
                    indicesTracker.poll();
                }
                kCounter--;
            }
        }
        for (int i = 0; i < indices.length; ++i) {
            System.out.println(indices[i]);
        }
        return maxValue;
    }

    public int findMaxSumSubArray(int k, int[] arr) {
        int windowStart = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int[] result = new int[k];
        for (int windowEnd = 0; windowEnd < arr.length; ++windowEnd) {
            currentSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    int j = 0;
                    for (int i = windowEnd - k + 1; i <= windowEnd; ++i) {
                        result[j++] = i;
                    }
                }
                currentSum -= arr[windowStart++];
            }
        }
        for (int i = 0; i < k; ++i) {
            System.out.print(result[i] + ",");
        }
        return maxSum;

    }

}
