package com.bitlrn.dgio.arrays;

/**
 * You are given an array of integers representing a journey on a bike,
 * wherein each number indicates a climb or descent in altitude,
 * measured as a gain or loss of height.
 * The rider starts at altitude 0.
 * Your task is to determine the highest altitude the biker
 * reaches at any point during the journey.
 */
public class HighAltitudeCalculator {

    public static void main(String[] args) {

    }

    public int largestAltitude(int[] gain) {
        int maxAltitude = Integer.MIN_VALUE; // To store the maximum altitude encountered
        int sum = 0;
        for (int i = 0; i < gain.length; ++i) {
            sum += gain[i];
            if (sum >= maxAltitude) {
                maxAltitude = sum;
            }
        }

        return maxAltitude;
    }
}
