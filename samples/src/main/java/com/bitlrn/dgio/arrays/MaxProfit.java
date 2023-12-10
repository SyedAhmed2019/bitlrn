package com.bitlrn.dgio.arrays;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        int[] result = mp.maxStockPrice(new int[]{2, 3, 4, 1});
        //result = mp.maxStockPrice(new int[]{4,5,0,1,2,8,7,6,3});
        result = mp.maxStockPrice(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0});
        for (int item : result) {
            System.out.print(item + ",");
        }

    }

    /**
     * Initial thoughts  -- error scenarios not handled.
     *
     * @param input
     * @return
     */
    int[] maxStockPriceInitial(int[] input) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        int maxIndex = input.length - 1;
        int maxValue = Integer.MIN_VALUE;
        int low = 0;
        int high = input.length - 1;
        while (low < high) {
            if (input[low] < minValue) {
                minValue = input[low];
                minIndex = low;
            }
            if (input[high] > maxValue) {
                maxValue = input[high];
                maxIndex = high;
            }
            low++;
            high--;
        }

        return new int[]{minIndex, maxIndex};

    }

    /**
     * Initial thoughts  -- error scenarios not handled.
     *
     * @param input
     * @return
     */
    int[] maxStockPrice(int[] input) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = -1;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] < minPrice) {
                minPrice = input[i];
                minIndex = i;
            }
            if (input[i] - minPrice >= maxProfit) {
                maxProfit = input[i] - minPrice;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};

    }
}
