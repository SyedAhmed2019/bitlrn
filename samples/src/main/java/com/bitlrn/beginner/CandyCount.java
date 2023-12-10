package com.bitlrn.beginner;

import java.util.HashMap;
import java.util.Map;

public class CandyCount {
    public static void main(String[] args) {
        CandyCount cc = new CandyCount();
        System.out.println(cc.candy(new int[]{1, 1, 2, 3}));
        System.out.println(cc.candy(new int[]{0, 0, 0, 2}));
        System.out.println(cc.candy(new int[]{1, 0, 2}));
    }

    public int candy(int[] ratings) {
        int candyCount = 0;
        int previousNeighbor = 1;
        Map<Integer, Integer> candyCounter = new HashMap<>();
        for (int i = 0; i < ratings.length; ++i) {
            int current = ratings[i];
            if (current > 0) {
                if (candyCounter.containsKey(current)) {
                    int count = candyCounter.get(current);
                    candyCounter.put(current, ++previousNeighbor);
                } else {
                    candyCounter.put(current, ++previousNeighbor);
                }
            } else {
                candyCount++;
                previousNeighbor = 1;
            }

        }
        for (int val : candyCounter.values()) {
            System.out.println("val=" + val);
            candyCount += val;
        }
        return candyCount;
    }
}
